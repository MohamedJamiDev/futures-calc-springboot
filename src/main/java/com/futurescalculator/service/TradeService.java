package com.futurescalculator.service;

import com.futurescalculator.exception.ContractNotFoundException;
import com.futurescalculator.model.Contract;
import com.futurescalculator.model.TradeRequest;
import com.futurescalculator.model.TradeResponse;
import com.futurescalculator.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                (!tradeRequest.getTradeDirection().equalsIgnoreCase("LONG") &&
                        !tradeRequest.getTradeDirection().equalsIgnoreCase("SHORT"))) {
            throw new IllegalArgumentException("Invalid trade direction. Must be 'LONG' or 'SHORT'.");
        }

        double priceDifference = tradeRequest.getExitPrice() - tradeRequest.getEntryPrice();

        // Reverse price difference for SHORT trades
        if ("SHORT".equalsIgnoreCase(tradeRequest.getTradeDirection())) {
            priceDifference = -priceDifference;
        }

        // Convert price difference to ticks
        double ticks = priceDifference / contract.getTickSize();

        // Calculate profit/loss
        double profitLoss = ticks * contract.getTickValue() * tradeRequest.getNumberOfContracts();

        return new TradeResponse(profitLoss);
    }
}