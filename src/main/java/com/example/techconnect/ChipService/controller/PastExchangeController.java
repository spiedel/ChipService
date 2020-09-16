package com.example.techconnect.ChipService.controller;

import com.example.techconnect.ChipService.models.PastExchange;
import com.example.techconnect.ChipService.repositories.PastExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PastExchangeController {

    @Autowired
    PastExchangeRepository pastExchangeRepository;

    @GetMapping(value = "/pastexchanges")
    public ResponseEntity<List<PastExchange>> getAllPastExchanges() {
        List<PastExchange> foundPastExchanges = pastExchangeRepository.findAll();
        return new ResponseEntity<>(foundPastExchanges, HttpStatus.OK);
    }

    @GetMapping(value = "/pastexchanges/{id}")
    public ResponseEntity<Optional<PastExchange>> getOnePastExchange(@PathVariable Long id) {
        Optional<PastExchange> foundPastExchange = pastExchangeRepository.findById(id);
        if (foundPastExchange.isPresent()) {
            return new ResponseEntity(foundPastExchange, HttpStatus.OK);
        } else {
            return new ResponseEntity(foundPastExchange, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/pastexchanges/{id}")
    public ResponseEntity<Optional<PastExchange>> removeOnePastExchange(@PathVariable Long id) {
        Optional<PastExchange> removedPastExchange = pastExchangeRepository.findById(id);
        if (removedPastExchange.isPresent()) {
            pastExchangeRepository.deleteById(id);
            return new ResponseEntity(removedPastExchange, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(removedPastExchange, HttpStatus.NOT_FOUND);
        }
    }
}
