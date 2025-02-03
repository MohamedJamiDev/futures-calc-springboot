package com.futurescalculator.config;

import com.futurescalculator.model.Contract;
import com.futurescalculator.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ContractRepository contractRepository;

    @Override
    public void run(String... args) throws Exception {
        contractRepository.save(new Contract("ES", 0.25, 12.50));
        contractRepository.save(new Contract("NQ", 0.25, 5.00));
        contractRepository.save(new Contract("CL", 0.01, 10.00));
        contractRepository.save(new Contract("GC", 0.10, 10.00));
    }
}