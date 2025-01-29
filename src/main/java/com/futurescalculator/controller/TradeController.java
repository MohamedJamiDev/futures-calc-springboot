package com.futurescalculator.controller;

import com.futurescalculator.model.TradeRequest;
import com.futurescalculator.model.TradeResponse;
import com.futurescalculator.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class TradeController {

    @Autowired
    private TradeService tradeService;

    @PostMapping
    public TradeResponse calculateProfitLoss(@RequestBody TradeRequest tradeRequest) {
        return tradeService.calculateProfitLoss(tradeRequest);
    }
}