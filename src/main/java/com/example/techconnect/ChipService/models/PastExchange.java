package com.example.techconnect.ChipService.models;

import com.example.techconnect.ChipService.payLoads.ExchangeRate;

import javax.persistence.*;

@Entity
@Table(name="Past_Exchanges")
public class PastExchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="date_and_time")
    private String dateAndTime;
    @Column(name="rate")
    private double rate;
    @Column(name="transaction_type")
    private String transactionType;

    public PastExchange() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}
