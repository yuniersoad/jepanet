package com.jepanet.model.elements;

public abstract class Element {
    
    private String ID;
    
    private String description;
    
    private String tag;

    public Element(String ID) {
        this.ID = ID;
    }
    
    public String getID() {
        return ID;
    }

    public String getDescription() {
        return description;
    }

    public String getTag() {
        return tag;
    }
    
}
