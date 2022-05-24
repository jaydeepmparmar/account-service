package com.tuum.account.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Balance {
    private Integer amount;
    private Currency currency;
}
