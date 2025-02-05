package com.futurescalculator.controller;

import com.futurescalculator.exception.ContractNotFoundException;
import com.futurescalculator.model.TradeRequest;
import com.futurescalculator.model.TradeResponse;
import com.futurescalculator.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<TradeResponse> calculateProfitLoss(@RequestBody TradeRequest tradeRequest) {
        try {
            TradeResponse response = tradeService.calculateProfitLoss(tradeRequest);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new TradeResponse("Invalid request: " + e.getMessage()));
        } catch (ContractNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new TradeResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TradeResponse("An unexpected error occurred."));
        }
    }
}