package com.jepanet.model.elements;

public class Valve extends Link {
    
    public static enum Type {
        PRV, PSV, PBV, FCV, TCV, GPV
    }
    
    public static enum FixedStatus {
        None,
        Open,
        Closed
    }
    
    private double diameter;
    private Type type;
    private String setting;
    private double lossCoeff;
    private FixedStatus fixedStatus;

    public Valve(String ID, String startNode, String endNode) {
        super(ID, startNode, endNode);
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    public double getLossCoeff() {
        return lossCoeff;
    }

    public void setLossCoeff(double lossCoeff) {
        this.lossCoeff = lossCoeff;
    }

    public FixedStatus getFixedStatus() {
        return fixedStatus;
    }

    public void setFixedStatus(FixedStatus fixedStatus) {
        this.fixedStatus = fixedStatus;
    }
    
}
