package com.jepanet.model.elements;

import java.util.ArrayList;
import java.util.List;


public class Junction extends Node {

    public static class DemandCategory {
        private double baseDemand;
        private double pattern;
        private String category;        
    }

    private double baseDemand;
    private double pattern;
    private List<DemandCategory> demandCategories;
    private double emitterCoeff;
    
    public Junction(String ID) {
        super(ID);
        demandCategories = new ArrayList<>();
    }

    public double getBaseDemand() {
        return baseDemand;
    }

    public void setBaseDemand(double baseDemand) {
        this.baseDemand = baseDemand;
    }

    public double getPattern() {
        return pattern;
    }

    public void setPattern(double pattern) {
        this.pattern = pattern;
    }
    
    public double getEmitterCoef() {
        return emitterCoeff;
    }

    public void setEmitterCoef(double emitterCoef) {
        this.emitterCoeff = emitterCoef;
    }
    
}
