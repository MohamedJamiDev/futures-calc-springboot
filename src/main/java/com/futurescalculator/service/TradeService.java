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
        // Fetch contract details from the database
        Contract contract = contractRepository.findByContractType(tradeRequest.getContractType());
        if (contract == null) {
            throw new ContractNotFoundException("Contract type not found: " + tradeRequest.getContractType());
        }

        // Calculate profit/loss
        double priceDifference = tradeRequest.getExitPrice() - tradeRequest.getEntryPrice();
        double ticks = priceDifference / contract.getTickSize();
        double profitLoss = ticks * contract.getTickValue() * tradeRequest.getNumberOfContracts();

        return new TradeResponse(profitLoss);
    }
}
