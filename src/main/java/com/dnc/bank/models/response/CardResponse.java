package com.dnc.bank.models.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CardResponse {
    private String id;
    private String numberCard;
    private String cvv;
    private String expirationDate;
    private String typeCard;
    private String account;
    private String clientId;
}
