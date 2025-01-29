package com.futurescalculator.model;

public class TradeRequest {

    private String contractName;
    private String direction; // "BUY" or "SELL"
    private double entryPrice;
    private double exitPrice;
    private int numberOfContracts;

    // Constructors
    public TradeRequest() {}

    public TradeRequest(String contractName, String direction, double entryPrice, double exitPrice, int numberOfContracts) {
        this.contractName = contractName;
        this.direction = direction;
        this.entryPrice = entryPrice;
        this.exitPrice = exitPrice;
        this.numberOfContracts = numberOfContracts;
    }

    // Getters and Setters
    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public double getEntryPrice() {
        return entryPrice;
    }

    public void setEntryPrice(double entryPrice) {
        this.entryPrice = entryPrice;
    }

    public double getExitPrice() {
        return exitPrice;
    }

    public void setExitPrice(double exitPrice) {
        this.exitPrice = exitPrice;
    }

    public int getNumberOfContracts() {
        return numberOfContracts;
    }

    public void setNumberOfContracts(int numberOfContracts) {
        this.numberOfContracts = numberOfContracts;
    }
}
