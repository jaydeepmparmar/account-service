package com.tuum.account.controller;

import com.tuum.account.entity.Account;
import com.tuum.account.model.AccountDTO;
import com.tuum.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
@Slf4j
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
    public ResponseEntity<Account> createAccount(@Valid @RequestBody AccountDTO account) {
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.createAccount(account));
    }


    /** Get account
Return the account object.
Input: • Account ID
Output: • Account ID • Customer ID • List of balances: o Available amount o Currency
Errors: • Account not found */
}
