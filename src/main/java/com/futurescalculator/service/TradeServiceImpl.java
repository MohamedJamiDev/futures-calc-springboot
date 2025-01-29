package com.futurescalculator.service;

import com.futurescalculator.model.TradeRequest;
import com.futurescalculator.model.TradeResponse;
import com.futurescalculator.model.Contract;
import com.futurescalculator.exception.ContractNotFoundException;
import com.futurescalculator.repository.ContractRepository;
import org.springframework.stereotype.Service;

@Service
public class TradeServiceImpl implements TradeService {

    private final ContractRepository contractRepository;

    public TradeServiceImpl(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public TradeResponse calculateProfitOrLoss(TradeRequest request) {
        // Find the contract
        Contract contract = contractRepository.findByName(request.getContractName());
        if (contract == null) {
            throw new ContractNotFoundException("Contract not found: " + request.getContractName());
        }

        // Calculate price difference
        double priceDifference = request.getExitPrice() - request.getEntryPrice();

        // Reverse price difference if direction is SELL
        if ("SELL".equalsIgnoreCase(request.getDirection())) {
            priceDifference = -priceDifference;
        }

        // Calculate profit/loss
        double profitOrLoss = priceDifference * contract.getTickValue() * request.getNumberOfContracts();

        return new TradeResponse(profitOrLoss);
    }
}
