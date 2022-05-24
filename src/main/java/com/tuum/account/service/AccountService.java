package com.tuum.account.service;

import com.tuum.account.dao.mapper.AccountMapper;
import com.tuum.account.entity.Account;
import com.tuum.account.mapper.AccountDTOMapper;
import com.tuum.account.model.AccountDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountDTOMapper accountDTOMapper;
    private final AccountMapper accountMapper;
    private final MessageSenderService messageSenderService;

    public Account createAccount(AccountDTO accountDTO) {
        Account account = accountDTOMapper.toEntity(accountDTO);
        messageSenderService.send(account.toString());
        accountMapper.createAccount(account);
        return account;
    }
}
