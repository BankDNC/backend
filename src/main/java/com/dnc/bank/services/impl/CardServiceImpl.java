package com.dnc.bank.services.impl;

import com.dnc.bank.models.mappers.CardMapper;
import com.dnc.bank.models.response.CardResponse;
import com.dnc.bank.repositories.CardRepository;
import com.dnc.bank.services.CardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CardServiceImpl implements CardService {

    private CardRepository cardRepository;

    private CardMapper cardMapper;

    @Override
    public List<CardResponse> getAllCardsByClientId(String clientId) {
        return cardMapper.toCardResponse(cardRepository.findAllByUserId(clientId));
    }
}
