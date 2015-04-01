package com.jepanet.model.elements;

public class Tank extends Node {
    
    private double initialLevel;
    private double minLevel;
    private double maxLevel;
    private double diameter;
    private double minVolume;
    private String volumeCurve;

    public Tank(String ID) {
        super(ID);
    }

    public double getInitialLevel() {
        return initialLevel;
    }

    public void setInitialLevel(double initialLevel) {
        this.initialLevel = initialLevel;
    }

    public double getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(double minLevel) {
        this.minLevel = minLevel;
    }

    public double getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(double maxLevel) {
        this.maxLevel = maxLevel;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getMinVolume() {
        return minVolume;
    }

    public void setMinVolume(double minVolume) {
        this.minVolume = minVolume;
    }

    public String getVolumeCurve() {
        return volumeCurve;
    }

    public void setVolumeCurve(String volumeCurve) {
        this.volumeCurve = volumeCurve;
    }
    
}
