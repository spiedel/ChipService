package com.example.techconnect.ChipService.controller;


import com.example.techconnect.ChipService.clients.ExchangeRateClient;
import com.example.techconnect.ChipService.payLoads.ExchangeRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChipController {

    @Autowired
    ExchangeRateClient exchangeRateClient;
    
    @GetMapping(value = "/chipValue")
    public ResponseEntity<Integer> getCurrentChipValue(@RequestParam (name = "amountToBuy", required = true) int amountOfMoney){

        ExchangeRate rates = exchangeRateClient.getExchangeRate();
        double rate = rates.getRates().get("GBP");
        if (amountOfMoney <= 150){
            rate = (amountOfMoney * rate) / 100;
        } else {
            rate = (150 * rate) / 100;
        }
        int chipExchange = (int) Math.ceil(rate * 5);
        return new ResponseEntity<>(chipExchange, HttpStatus.OK);

    }
}
