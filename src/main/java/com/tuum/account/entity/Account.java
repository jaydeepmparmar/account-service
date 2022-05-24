package com.tuum.account.entity;

import com.tuum.account.model.Balance;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private Integer accountId;
    private String country;
    private String customerId;
    private List<Balance> balanceList;

}
