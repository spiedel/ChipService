package com.example.techconnect.ChipService.repositories;

import com.example.techconnect.ChipService.models.PastExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PastExchangeRepository extends JpaRepository<PastExchange, Long> {
}
