package com.dnc.bank.services;

import com.dnc.bank.models.request.AuthRequest;
import com.dnc.bank.models.response.AuthResponse;

public interface AuthService {
    public AuthResponse login(AuthRequest authRequest);
}
