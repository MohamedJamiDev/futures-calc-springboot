package com.futurescalculator.model;

public class TradeResponse {
    private double profitLoss;

    public TradeResponse() {}

    public TradeResponse(double profitLoss) {
        this.profitLoss = profitLoss;
    }

    public double getProfitLoss() {
        return profitLoss;
    }

    public void setProfitLoss(double profitLoss) {
        this.profitLoss = profitLoss;
    }
}