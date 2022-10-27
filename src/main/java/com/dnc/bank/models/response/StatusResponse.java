package com.dnc.bank.models.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StatusResponse {
    private String message;
}
