package com.pblgllgs.banking.service.impl;
/*
 *
 * @author pblgl
 * Created on 22-11-2024
 *
 */

import com.pblgllgs.banking.dto.AccountDto;
import com.pblgllgs.banking.entity.Account;
import com.pblgllgs.banking.exception.InsufficientBalanceException;
import com.pblgllgs.banking.exception.ResourceNotFoundException;
import com.pblgllgs.banking.mapper.AccountMapper;
import com.pblgllgs.banking.repository.AccountRepository;
import com.pblgllgs.banking.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public AccountDto getAccount(Long accountId) {
        Optional<Account> account = exitsAccount(accountId);
        return AccountMapper.toAccountDto(account.get());
    }

    @Override
    public AccountDto deposit(Long accountId, double amount) {
        Optional<Account> account = exitsAccount(accountId);
        Account accountToDeposit = account.get();
        accountToDeposit.setBalance(accountToDeposit.getBalance() + amount);
        Account savedAccount = accountRepository.save(accountToDeposit);
        return AccountMapper.toAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long accountId, double amount) {
        Optional<Account> account = exitsAccount(accountId);
        Account accountToDeposit = account.get();
        accountToDeposit.setBalance(accountToDeposit.getBalance() - amount);
        if (accountToDeposit.getBalance() < 0) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        Account savedAccount = accountRepository.save(accountToDeposit);
        return AccountMapper.toAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        return accountRepository.findAll().stream().map(AccountMapper::toAccountDto).toList();
    }

    @Override
    public void deleteAccount(Long accountId) {
        Optional<Account> account = exitsAccount(accountId);
        accountRepository.delete(account.get());
    }

    private Optional<Account> exitsAccount(Long accountId) {
        Optional<Account> account = accountRepository.findById(accountId);
        if (account.isEmpty()) {
            throw new ResourceNotFoundException("Account not found");
        }
        return account;
    }
}
