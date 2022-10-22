package com.dnc.bank.services.impl;

import com.dnc.bank.models.request.AuthRequest;
import com.dnc.bank.models.response.AuthResponse;
import com.dnc.bank.security.TokenUtils;
import com.dnc.bank.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;

    @Override
    public AuthResponse login(AuthRequest authRequest) {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
            String token = TokenUtils.createToken(authRequest.getEmail());
            return new AuthResponse(token);
        }catch (Exception e){
            return new AuthResponse();
        }
    }
}
