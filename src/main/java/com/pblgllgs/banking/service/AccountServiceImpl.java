package com.pblgllgs.banking.service;
/*
 *
 * @author pblgl
 * Created on 22-11-2024
 *
 */

import com.pblgllgs.banking.dto.AccountDto;
import com.pblgllgs.banking.entity.Account;
import com.pblgllgs.banking.mapper.AccountMapper;
import com.pblgllgs.banking.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public AccountDto addAccount(AccountDto accountDto) {
        Account account = AccountMapper.toAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.toAccountDto(savedAccount);
    }
}
