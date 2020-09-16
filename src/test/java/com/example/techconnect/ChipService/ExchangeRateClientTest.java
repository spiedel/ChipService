package com.example.techconnect.ChipService;

import com.example.techconnect.ChipService.clients.ExchangeRateClient;
import com.example.techconnect.ChipService.payLoads.ExchangeRate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = {ChipServiceApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
public class ExchangeRateClientTest {


    @Autowired
    ExchangeRateClient exchangeRateClient;


    @Test
    public void canGetExchangeRate(){
        ExchangeRate exchangeRate = exchangeRateClient.getExchangeRate();

    }


}
