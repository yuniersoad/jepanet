package com.jepanet.model.elements;

public abstract class Link extends Element {
    
    private String startNodeId;
    private String endNodeId;
    
    public Link(String ID, String startNode, String endNode) {
        super(ID);
        startNodeId = startNode;
        endNodeId = endNode;
    }

    public String getStartNodeId() {
        return startNodeId;
    }

    public String getEndNodeId() {
        return endNodeId;
    }
    
}
