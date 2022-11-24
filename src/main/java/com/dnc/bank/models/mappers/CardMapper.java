package com.dnc.bank.models.mappers;

import com.dnc.bank.models.documents.Card;
import com.dnc.bank.models.response.CardResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CardMapper {

        public CardResponse toCardResponse(Card card) {
            return CardResponse.builder()
                    .id(card.getId())
                    .numberCard(card.getNumberCard())
                    .cvv(card.getCvv())
                    .expirationDate(card.getExpirationDate())
                    .typeCard(card.getTypeCard())
                    .account(card.getAccount())
                    .clientId(card.getId())
                    .build();
        }

        public List<CardResponse> toCardResponse(List<Card> cards) {
            return cards.parallelStream().map(this::toCardResponse).toList();
        }
}
