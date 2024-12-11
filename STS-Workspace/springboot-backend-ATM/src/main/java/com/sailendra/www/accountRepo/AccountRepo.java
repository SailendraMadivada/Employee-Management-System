package com.sailendra.www.accountRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sailendra.www.account.Account;

public interface AccountRepo extends JpaRepository<Account, String> {
    Account findByAccountNumber(String accountNumber);
}
