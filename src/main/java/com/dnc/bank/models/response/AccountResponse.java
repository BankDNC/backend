package com.dnc.bank.models.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountResponse {
    private String id;
    private String number;
    private Double balance;
}
