package GUI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class note {
	
	
	
	private String step, type ;
	
	private int octave, duration, voice, string, fret;
	
	public String getStep() {
		return step;
	}
	public void setStep(String step) {
		this.step = step;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getOctave() {
		return octave;
	}
	public void setOctave(int octave) {
		this.octave = octave;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getVoice() {
		return voice;
	}
	public void setVoice(int voice) {
		this.voice = voice;
	}
	public int getString() {
		return string;
	}
	public void setString(int string) {
		this.string = string;
	}
	public int getFret() {
		return fret;
	}
	public void setFret(int fret) {
		this.fret = fret;
	}
}
