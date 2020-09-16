package com.example.techconnect.ChipService;

import com.example.techconnect.ChipService.models.PastExchange;
import com.example.techconnect.ChipService.repositories.PastExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PastExchangeRepository pastExchangeRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        PastExchange pastExchange = new PastExchange();
        pastExchange.setDateAndTime("now");
        pastExchange.setRate(5.0);
        pastExchangeRepository.save(pastExchange);

        PastExchange pastExchange2 = new PastExchange();
        pastExchange2.setDateAndTime("later");
        pastExchange2.setRate(7.0);
        pastExchangeRepository.save(pastExchange2);

    }
}
