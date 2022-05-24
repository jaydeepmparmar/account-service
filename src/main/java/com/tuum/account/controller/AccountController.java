package com.tuum.account.controller;

import com.tuum.account.entity.Account;
import com.tuum.account.model.AccountDTO;
import com.tuum.account.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
@Slf4j
public class AccountController {

    private final AccountService accountService;

    @Operation(summary = "Creates a new customer account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created account"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Server Error")})
    @PostMapping
    public ResponseEntity<Account> createAccount(@Valid @RequestBody AccountDTO account) {
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.createAccount(account));
    }


    /** Get account
Return the account object.
Input: • Account ID
Output: • Account ID • Customer ID • List of balances: o Available amount o Currency
Errors: • Account not found */

    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccountById(@PathVariable String accountId) {
        return ResponseEntity.status(HttpStatus.OK).body(accountService.getAccountById(accountId));
    }
}
