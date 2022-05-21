package com.tuum.account.model;

import lombok.Data;

@Data
public class Balance {
    private Double amount;
    private Currency currency;
}
