package com.sailendra.www.atmService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sailendra.www.account.Account;
import com.sailendra.www.accountRepo.AccountRepo;

@Service
public class AtmService {

    @Autowired
    private AccountRepo accountRepository;

    // Check balance
    public double checkBalance(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new RuntimeException("Account not found.");
        }
        return account.getBalance();
    }

    // Deposit money
    public double deposit(String accountNumber, double amount) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new RuntimeException("Account not found.");
        }
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);
        return account.getBalance();
    }

    // Withdraw money
    public double withdraw(String accountNumber, double amount) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new RuntimeException("Account not found.");
        }
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds.");
        }
        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);
        return account.getBalance();
    }
}
