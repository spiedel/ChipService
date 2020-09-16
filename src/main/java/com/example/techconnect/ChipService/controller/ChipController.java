package com.example.techconnect.ChipService.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChipController {


    @GetMapping(value = "/chipValue")
    public ResponseEntity<Integer> getCurrentChipValue(){
        return new ResponseEntity<>(7, HttpStatus.OK);
    }
}
