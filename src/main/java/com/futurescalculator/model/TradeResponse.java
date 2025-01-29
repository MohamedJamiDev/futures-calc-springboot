package com.futurescalculator.model;

public class TradeResponse {

    private double profitOrLoss;

    public TradeResponse() {}

    public TradeResponse(double profitOrLoss) {
        this.profitOrLoss = profitOrLoss;
    }

    // Getter and Setter
    public double getProfitOrLoss() {
        return profitOrLoss;
    }

    public void setProfitOrLoss(double profitOrLoss) {
        this.profitOrLoss = profitOrLoss;
    }
}
