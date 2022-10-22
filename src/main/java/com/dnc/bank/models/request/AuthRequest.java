package com.dnc.bank.models.request;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
