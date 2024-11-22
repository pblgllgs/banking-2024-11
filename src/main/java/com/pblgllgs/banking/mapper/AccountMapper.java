package com.pblgllgs.banking.mapper;
/*
 *
 * @author pblgl
 * Created on 22-11-2024
 *
 */

import com.pblgllgs.banking.dto.AccountDto;
import com.pblgllgs.banking.entity.Account;

public class AccountMapper {

    public static Account toAccount(AccountDto accountDto) {
        return new Account(
                accountDto.id(),
                accountDto.accountHolderName(),
                accountDto.balance()
        );
    }

    public static AccountDto toAccountDto(Account account) {
        return new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
    }
}
