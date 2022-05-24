package com.tuum.account.mapper;

import com.tuum.account.entity.Account;
import com.tuum.account.model.AccountDTO;
import com.tuum.account.model.Balance;
import com.tuum.account.model.Currency;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper to convert Account DTO to Entity
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountDTOMapper {

    @Mapping(target = "balanceList", source = "currencies", qualifiedByName = "mapBalance")
    Account toEntity(AccountDTO account);

    @Named("mapBalance")
    default List<Balance> mapAccountType(List<Currency> currencies) {
        return currencies.stream()
                .map(currency -> Balance.builder()
                        .currency(currency)
                        .amount(100)
                        .build())
                .collect(Collectors.toList());
    }
}
