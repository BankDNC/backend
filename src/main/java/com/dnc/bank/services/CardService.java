package com.dnc.bank.services;

import com.dnc.bank.models.response.CardResponse;

import java.util.List;

public interface CardService {

    List<CardResponse> getAllCardsByClientId(String clientId);
}
