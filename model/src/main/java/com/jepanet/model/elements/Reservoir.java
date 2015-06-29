package com.jepanet.model.elements;

public class Reservoir extends Node {

    //Node.elevation represents the Total Head
    
    private String headPattern;
    
    public Reservoir(String ID) {
        super(ID);
    }

    public String getHeadPattern() {
        return headPattern;
    }

    public void setHeadPattern(String headPattern) {
        this.headPattern = headPattern;
    }    
}
