package com.dnc.bank.models.mappers;

import com.dnc.bank.models.documents.Account;
import com.dnc.bank.models.response.AccountResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountMapper {

    public AccountResponse toAccountResponse(Account account) {
        return AccountResponse.builder()
                .id(account.getId())
                .number(account.getNumber())
                .balance(account.getBalance())
                .build();
    }

    public List<AccountResponse> toAccountResponse(List<Account> accounts) {
        return accounts.parallelStream().map(this::toAccountResponse).toList();
    }

}
