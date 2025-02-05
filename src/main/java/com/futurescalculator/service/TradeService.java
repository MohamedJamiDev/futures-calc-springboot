package com.futurescalculator.service;

import com.futurescalculator.exception.ContractNotFoundException;
import com.futurescalculator.model.Contract;
import com.futurescalculator.model.TradeRequest;
import com.futurescalculator.model.TradeResponse;
import com.futurescalculator.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class TradeService {

    @Autowired
    private ContractRepository contractRepository;

    public TradeResponse calculateProfitLoss(TradeRequest tradeRequest) {
        Contract contract = contractRepository.findByContractType(tradeRequest.getContractType());
        if (contract == null) {
            throw new ContractNotFoundException("Contract type not found: " + tradeRequest.getContractType());
        }

        if (tradeRequest.getTradeDirection() == null ||
                (!tradeRequest.getTradeDirection().equalsIgnoreCase("BUY") &&
                        !tradeRequest.getTradeDirection().equalsIgnoreCase("SELL"))) {
            throw new IllegalArgumentException("Invalid trade direction. Must be 'BUY' or 'SELL'.");
        }

        double rawProfitOrLoss = calculateProfitOrLoss(
                tradeRequest.getEntryPrice(),
                tradeRequest.getExitPrice(),
                tradeRequest.getNumberOfContracts(),
                contract,
                tradeRequest.getTradeDirection()
        );

        BigDecimal profitOrLoss = BigDecimal.valueOf(rawProfitOrLoss).setScale(2, RoundingMode.HALF_UP);
        String statusMessage;

        if (profitOrLoss.doubleValue() > 0) {
            statusMessage = "Profit: $" + profitOrLoss;
        } else if (profitOrLoss.doubleValue() < 0) {
            statusMessage = "Loss: $" + profitOrLoss; 
        } else {
            statusMessage = "Break-even (no profit or loss)";
        }

        return new TradeResponse(statusMessage);
    }

    private double calculateProfitOrLoss(double entryPrice, double exitPrice,
                                         int numberOfContracts, Contract contract, String tradeDirection) {
        double pointDifference = tradeDirection.equalsIgnoreCase("BUY") ?
                exitPrice - entryPrice : entryPrice - exitPrice;

        return pointDifference * contract.getTickValue() * numberOfContracts;
    }
}