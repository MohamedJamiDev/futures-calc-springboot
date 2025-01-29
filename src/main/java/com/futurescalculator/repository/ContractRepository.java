package com.futurescalculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.futurescalculator.model.Contract;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    // Custom method to find a contract by its name
    Contract findByName(String name);
}

