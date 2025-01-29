package com.futurescalculator.controller;

import com.futurescalculator.model.TradeRequest;
import com.futurescalculator.model.TradeResponse;
import com.futurescalculator.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class TradeController {

    @Autowired
    private TradeService tradeService;

    @PostMapping("/calculate")
    public TradeResponse calculateProfitOrLoss(@RequestBody TradeRequest request) {
        return tradeService.calculateProfitOrLoss(request);
    }
}