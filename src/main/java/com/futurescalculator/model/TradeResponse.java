package com.futurescalculator.model;

public class TradeResponse {
    private double profitLoss;

    // No-argument constructor for deserialization
    public TradeResponse() {}

    // Constructor with profitLoss
    public TradeResponse(double profitLoss) {
        this.profitLoss = profitLoss;
    }

    // Getters and Setters
    public double getProfitLoss() {
        return profitLoss;
    }

    public void setProfitLoss(double profitLoss) {
        this.profitLoss = profitLoss;
    }
}