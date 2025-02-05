package com.futurescalculator.model;

public class TradeResponse {
    private String message;

    public TradeResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}