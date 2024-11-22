package com.pblgllgs.banking.dto;
/*
 *
 * @author pblgl
 * Created on 22-11-2024
 *
 */

public record AccountDto(
        Long id,
        String accountHolderName,
        double balance
) {}
