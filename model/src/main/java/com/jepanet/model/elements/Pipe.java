package com.jepanet.model.elements;

public class Pipe extends Link {

    public static enum InitialStatus {
       Open,
       Closed,
       CV
    }
 
    private double length;
    private double diameter;
    private double roughness;
    private double lossCoeff;
    private InitialStatus initialStatus;
    
    
    public Pipe(String ID, String startNode, String endNode) {
        super(ID, startNode, endNode);
        initialStatus = InitialStatus.Open; 
    }
    
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    
    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getRoughness() {
        return roughness;
    }

    public void setRoughness(double roughness) {
        this.roughness = roughness;
    }

    public double getLossCoeff() {
        return lossCoeff;
    }

    public void setLossCoeff(double lossCoeff) {
        this.lossCoeff = lossCoeff;
    }

    public InitialStatus getInitialStatus() {
        return initialStatus;
    }

    public void setInitialStatus(InitialStatus initialStatus) {
        this.initialStatus = initialStatus;
    }
    
}
