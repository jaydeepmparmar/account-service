package com.tuum.account.service;

import com.tuum.account.model.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    public Account createAccount() {
        return new Account();
    }
}
