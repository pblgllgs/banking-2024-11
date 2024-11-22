package com.pblgllgs.banking.controller;
/*
 *
 * @author pblgl
 * Created on 22-11-2024
 *
 */

import com.pblgllgs.banking.dto.AccountDto;
import com.pblgllgs.banking.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.addAccount(accountDto), HttpStatus.CREATED);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountDto> findById(@PathVariable("accountId") Long accountId){
        return new ResponseEntity<>(accountService.getAccount(accountId), HttpStatus.OK);
    }

    @PutMapping("/{accountId}/deposit")
    public ResponseEntity<AccountDto> deposit(
            @PathVariable("accountId") Long accountId,
            @RequestBody Map<String,Double> request
    ){
        return new ResponseEntity<>(accountService.deposit(accountId, request.get("amount")), HttpStatus.OK);
    }

    @PutMapping("/{accountId}/withdrow")
    public ResponseEntity<AccountDto> withdrow(
            @PathVariable("accountId") Long accountId,
            @RequestBody Map<String,Double> request
    ){
        return new ResponseEntity<>(accountService.withdraw(accountId, request.get("amount")), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> findAll(){
        return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<String> deleteAccount(@PathVariable("accountId") Long accountId){
        accountService.deleteAccount(accountId);
        return new ResponseEntity<>("Account deleted successfully", HttpStatus.OK);
    }
}
