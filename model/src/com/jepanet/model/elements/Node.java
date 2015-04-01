package com.jepanet.model.elements;

public abstract class Node extends Element {
    
    private double xCoordiante;
    private double yCoordinate;
    private double elevation;
    
    
    public Node(String ID) {
        super(ID);
    }

    public double getxCoordiante() {
        return xCoordiante;
    }

    public void setxCoordiante(double xCoordiante) {
        this.xCoordiante = xCoordiante;
    }

    public double getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public double getElevation() {
        return elevation;
    }

    public void setElevation(double elevation) {
        this.elevation = elevation;
    }
    
}
