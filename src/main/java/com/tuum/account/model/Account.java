package com.tuum.account.model;

import lombok.Data;

import java.util.List;

@Data
public class Account {

    private Long accountId;
    private Long customerId;
    private List<Balance> balanceList;

}
