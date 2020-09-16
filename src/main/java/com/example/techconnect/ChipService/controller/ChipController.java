package com.example.techconnect.ChipService.controller;


import com.example.techconnect.ChipService.clients.ExchangeRateClient;
import com.example.techconnect.ChipService.payLoads.ExchangeRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChipController {

    @Autowired
    ExchangeRateClient exchangeRateClient;


    @GetMapping(value = "/chipValue")
    public ResponseEntity<Integer> getCurrentChipValue(){


            ExchangeRate rates = exchangeRateClient.getExchangeRate();
            double rate = rates.getRates().get("GBP");
            double chipRate = 7 * rate;
            int chipRateRounded = (int) Math.round(chipRate);
            return new ResponseEntity<>(chipRateRounded, HttpStatus.OK);

    }
}
