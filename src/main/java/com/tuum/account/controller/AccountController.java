package com.tuum.account.controller;

import com.tuum.account.model.Account;
import com.tuum.account.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AccountController {
    /** Create account
Creates a bank account for the customer and returns an account object
together with balance objects.
Input: • Customer ID • Country • List of currencies (allowed values are EUR, SEK, GBP, USD)
Output: • Account ID • Customer ID • List of balances: o Available amount o Currency
Errors: • Invalid currency
API must create balances for the account in given currencies. */

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody String accountId) {
        return new ResponseEntity<>(accountService.createAccount(), HttpStatus.CREATED);
    }


    /** Get account
Return the account object.
Input: • Account ID
Output: • Account ID • Customer ID • List of balances: o Available amount o Currency
Errors: • Account not found */
}
