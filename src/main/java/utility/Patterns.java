package utility;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import converter.note.NoteFactory;

public class Patterns {
    public static final String WHITESPACE = "[^\\S\\n\\r]";
    //public static final String COMMENT = "^[^\\S\\n\\r]*#.+(?=\\n)";
    public static final String DIVIDER_COMPONENTS = "|{}";
    public static final String DIVIDER = "["+DIVIDER_COMPONENTS+"]";

    // e------------ or |e---------------- or |e|-------------------- when it is the first measure of the measure group (start of line, SOL)
    public static String START_OF_LINE = "(" + startOfLinePattern() + insidesPattern() + ")";

    //|--------------------- when it is in between other measures
    public static String MIDDLE_OF_LINE = "("+Patterns.DIVIDER+"+" + insidesPattern()+")";

    public static String INSIDES_PATTERN = insidesPattern();

    public static String INSIDES_PATTERN_SPECIAL_CASE = "$a"; // doesn't match anything
    
    private static String tabData() {
    	//return "(?:" + NoteFactory.GUITAR_NOTE_PATTERN + "|" + NoteFactory.GUITAR_NOTE_CONNECTOR + "|" + NoteFactory.DRUM_NOTE_PATTERN = ")";
        return "[^-\\n"+Patterns.DIVIDER_COMPONENTS+"]";
    }

    /**
     * A very general, very vague "inside a tab row line" pattern. We want to be as general and vague as possible so that
     * we delay catching erroneous user input until we are able to pinpoint where the error is exactly. e.g. if this
     * pattern directly detects a wrong note here, a Note object will never be created. It will just tell the user the
     * measure line where the error is, not the precise note which caused the error.
     * This regex pattern verifies if it is surrounded by |'s or a measure line name and captures a max of one | at each end
     * only if it is surrounded by more than one | (i.e ||------| extracts |------ and ||------||| extracts |------|, but |------| extracts ------)
     * @return the bracket-enclosed String regex pattern.
     */
    private static String insidesPattern() {
    	StringBuilder pattern = new StringBuilder();
    	pattern.append("("+INSIDES_PATTERN_SPECIAL_CASE);
    	pattern.append("|"+INSIDES_PATTERN_SPECIAL_CASE);
    	
    	// Positive lookbehind
    	pattern.append("|(?<=(?:[ \\r\\n]" + actualName() + ")");
    	pattern.append("(?=[ -][^" + DIVIDER_COMPONENTS + "])|" + DIVIDER + ")");
    	
    	// Actual expression to match
    	pattern.append(DIVIDER + "?");
    	pattern.append("(?:");
    		pattern.append("(?:" + WHITESPACE + "*[-*]+)");
    			pattern.append("|");
    		pattern.append("(?:" + WHITESPACE + "*"+ tabData() + "+" + WHITESPACE + "*-+)");
    		pattern.append(")");
    	pattern.append("(?:" + tabData() + "+-+)*");
    	pattern.append("(?:" + tabData() + "+ *)?");
    	pattern.append("(?:" + DIVIDER + "?" + "(?=" + DIVIDER + "))");
    	
    	pattern.append(")");
        return pattern.toString();
    }

    //Matches the name and a possible divider after it
    private static String startOfLinePattern() {
        StringBuilder pattern = new StringBuilder();
        pattern.append("(?:");
        pattern.append(WHITESPACE + "*" + DIVIDER + "*" + WHITESPACE + "*");
        pattern.append(actualName());
        pattern.append(WHITESPACE + "*");
        pattern.append("(?:(?=-)|(?:" + DIVIDER + "+))");
        pattern.append(")");
        return pattern.toString();
    }
    
    public static String measureNameExtractPattern() {
        StringBuilder pattern = new StringBuilder();
        pattern.append("(?<=^" + DIVIDER + "*" + ")");
        pattern.append(WHITESPACE + "*");
        pattern.append(actualName());
        pattern.append(WHITESPACE + "*");
        pattern.append("(?=-|" + DIVIDER + ")");  // what's ahead is a dash or a divider
        return pattern.toString();
    }
    
    private static String actualName() {
        Iterator<String> measureLineNames = getValidNames().iterator();
        StringBuilder pattern = new StringBuilder();
        //pattern.append("(?:[a-zA-Z]{1,3}|(?:"+measureLineNames.next());
        pattern.append("(?:"+measureLineNames.next());
        while(measureLineNames.hasNext()) {
            pattern.append("|"+measureLineNames.next());
        }
        pattern.append(")");
        return pattern.toString();
    }
    
    private static Set<String> getValidNames() {
        HashSet<String> nameSet = new HashSet<>();
        nameSet.addAll(GuitarUtils.getValidGuitarNames());
        nameSet.addAll(DrumUtils.getNickNameSet());
        return nameSet;
    }
}
