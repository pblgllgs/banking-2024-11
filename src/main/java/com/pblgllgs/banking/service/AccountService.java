package com.pblgllgs.banking.service;

import com.pblgllgs.banking.dto.AccountDto;

import java.util.List;

public interface AccountService {
    AccountDto addAccount(AccountDto accountDto);
    AccountDto getAccount(Long accountId);
    AccountDto deposit(Long accountId, double amount);
    AccountDto withdraw(Long accountId, double amount);
    List<AccountDto> getAllAccounts();
    void deleteAccount(Long accountId);
}
