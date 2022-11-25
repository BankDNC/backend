package com.dnc.bank.services;

import com.dnc.bank.models.response.AccountResponse;

import java.util.List;

public interface AccountService {

    List<AccountResponse> getAllAccountsByClientId(String clientId);
}
