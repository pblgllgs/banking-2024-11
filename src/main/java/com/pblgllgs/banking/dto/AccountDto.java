package com.pblgllgs.banking.dto;
/*
 *
 * @author pblgl
 * Created on 22-11-2024
 *
 */

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private Long id;
    private String accountHolderName;
    private double balance;
}
