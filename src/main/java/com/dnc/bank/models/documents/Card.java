package com.dnc.bank.models.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cards")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Card {
    @Id
    private String id;
    private String numberCard;
    private String cvv;
    private String expirationDate;
    private String typeCard;
    private String account;
    private String userId;
}
