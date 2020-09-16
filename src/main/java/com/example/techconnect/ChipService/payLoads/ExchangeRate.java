package com.example.techconnect.ChipService.payLoads;

import java.util.HashMap;

public class ExchangeRate {

    private HashMap<String, Double> rates;
    private String base;
    private String date;

    public ExchangeRate() {
    }


    public HashMap<String, Double> getRates() {
        return rates;
    }

    public void setRates(HashMap<String, Double> rates) {
        this.rates = rates;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
