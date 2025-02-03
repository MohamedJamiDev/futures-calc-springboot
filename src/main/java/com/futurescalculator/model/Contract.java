package com.futurescalculator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contractType;
    private double tickSize;
    private double tickValue;


    public Contract() {}

    public Contract(String contractType, double tickSize, double tickValue) {
        this.contractType = contractType;
        this.tickSize = tickSize;
        this.tickValue = tickValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public double getTickSize() {
        return tickSize;
    }

    public void setTickSize(double tickSize) {
        this.tickSize = tickSize;
    }

    public double getTickValue() {
        return tickValue;
    }

    public void setTickValue(double tickValue) {
        this.tickValue = tickValue;
    }
}

