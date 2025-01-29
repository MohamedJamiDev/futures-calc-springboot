package com.futurescalculator.service;

import com.futurescalculator.model.TradeRequest;
import com.futurescalculator.model.TradeResponse;

public interface TradeService {
    TradeResponse calculateProfitOrLoss(TradeRequest request);
}
