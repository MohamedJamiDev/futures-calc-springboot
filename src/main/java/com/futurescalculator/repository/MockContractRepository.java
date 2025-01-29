package com.futurescalculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.futurescalculator.model.Contract;
import org.springframework.stereotype.Repository;

@Repository
public interface MockContractRepository extends JpaRepository<Contract, Long> {
    // No need to manually implement findAll() or other methods
}
