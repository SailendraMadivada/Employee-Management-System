package com.sailendra.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sailendra.www.atmService.AtmService;

@RestController
@RequestMapping("/api/atm")
public class Controller {

    @Autowired
    private AtmService atmService;

    @GetMapping("/balance/{accountNumber}")
    public double getBalance(@PathVariable String accountNumber) {
        return atmService.checkBalance(accountNumber);
    }

    @PostMapping("/deposit/{accountNumber}")
    public double deposit(@PathVariable String accountNumber, @RequestParam double amount) {
        return atmService.deposit(accountNumber, amount);
    }

    @PostMapping("/withdraw/{accountNumber}")
    public double withdraw(@PathVariable String accountNumber, @RequestParam double amount) {
        return atmService.withdraw(accountNumber, amount);
    }
}