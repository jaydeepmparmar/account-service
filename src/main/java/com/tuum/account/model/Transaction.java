package com.tuum.account.model;

import lombok.Data;

@Data
public class Transaction {

    private Long accountId;
    private Long transactionId;
    private Balance transactionAmount;
    private Direction direction;
    private String description;
    private Balance balance;

}
