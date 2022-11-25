package com.dnc.bank.services.impl;

import com.dnc.bank.models.mappers.AccountMapper;
import com.dnc.bank.models.response.AccountResponse;
import com.dnc.bank.repositories.AccountRepository;
import com.dnc.bank.services.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    private AccountMapper accountMapper;

    @Override
    public List<AccountResponse> getAllAccountsByClientId(String clientId) {
        return accountMapper.toAccountResponse(accountRepository.findAllByUserId(clientId));
    }
}
