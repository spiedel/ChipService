package com.example.techconnect.ChipService.controller;


import com.example.techconnect.ChipService.clients.ExchangeRateClient;
import com.example.techconnect.ChipService.models.PastExchange;
import com.example.techconnect.ChipService.payLoads.ExchangeRate;
import com.example.techconnect.ChipService.repositories.PastExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@RestController
public class ChipController {

    @Autowired
    ExchangeRateClient exchangeRateClient;

    @Autowired
    PastExchangeRepository pastExchangeRepository;

    @GetMapping(value = "/chipValue")
    public ResponseEntity<Double> getCurrentChipValue(
            @RequestParam(name = "amountToBuy", required = false) Integer amountOfMoney){
        PastExchange pastExchanges = new PastExchange();
        pastExchanges.setTransactionType("sell");

        ExchangeRate rates = exchangeRateClient.getExchangeRate();
        double rate = rates.getRates().get("GBP");
        if (amountOfMoney != null) {
            if (amountOfMoney <= 150) {
                rate = Math.tanh(rate/150 * amountOfMoney);
            } pastExchanges.setTransactionType("buy");
        }

        double chipExchange = Math.round(rate * 5 * 100) / 100;
        if(chipExchange <1){
            chipExchange = 1; }

        LocalDateTime localDateAndTime = LocalDateTime.now();
        pastExchanges.setDateAndTime(localDateAndTime.toString());
        pastExchanges.setRate(chipExchange);
        pastExchangeRepository.save(pastExchanges);
        return new ResponseEntity<>(chipExchange, HttpStatus.OK);
    }
}
