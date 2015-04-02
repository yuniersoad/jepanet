package com.jepanet.model.elements;

public class Pump extends Link {

    public static enum InitialStatus {
       Open,
       Closed,
    }
    
    private String curve;
    private double power;
    private double speed;
    private String pattern;
    private InitialStatus initialStatus;
    private String efficiencyCurve;
    private double energyPrice;
    private String pricePattern;
    
    public Pump(String ID, String startNode, String endNode) {
        super(ID, startNode, endNode);
        initialStatus = InitialStatus.Open;
    }

    public String getCurve() {
        return curve;
    }

    public void setCurve(String curve) {
        this.curve = curve;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public InitialStatus getInitialStatus() {
        return initialStatus;
    }

    public void setInitialStatus(InitialStatus initialStatus) {
        this.initialStatus = initialStatus;
    }

    public String getEfficiencyCurve() {
        return efficiencyCurve;
    }

    public void setEfficiencyCurve(String efficiencyCurve) {
        this.efficiencyCurve = efficiencyCurve;
    }

    public double getEnergyPrice() {
        return energyPrice;
    }

    public void setEnergyPrice(double energyPrice) {
        this.energyPrice = energyPrice;
    }

    public String getPricePattern() {
        return pricePattern;
    }

    public void setPricePattern(String pricePattern) {
        this.pricePattern = pricePattern;
    }
    
}
