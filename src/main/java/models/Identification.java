package models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Identification {
	
	@JacksonXmlProperty(localName = "creator")
	Creator creator;
	
    public Identification(Creator creator) {
        this.creator = creator;
    }
    
//    public Identification() {
//        
//    }

    public Creator getCreator() {
        return creator;
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
    }
}
