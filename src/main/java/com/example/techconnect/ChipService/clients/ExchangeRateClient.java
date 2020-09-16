package com.example.techconnect.ChipService.clients;


import com.example.techconnect.ChipService.payLoads.ExchangeRate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ExchangeRateClient {

    public ExchangeRateClient() {
    }

    public ExchangeRate getExchangeRate(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://api.exchangeratesapi.io/latest?symbols=GBP", ExchangeRate.class);
    }


}
