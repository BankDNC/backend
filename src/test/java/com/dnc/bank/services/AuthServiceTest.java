package com.dnc.bank.services;

import com.dnc.bank.models.request.AuthRequest;
import com.dnc.bank.services.impl.AuthServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class AuthServiceTest {

    @Mock
    private AuthenticationManager authenticationManager;
    @InjectMocks
    private AuthServiceImpl authService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void loginIsOk(){
        when(authenticationManager.authenticate(any())).thenReturn(null);
        assertNotNull(authService.login(generateAuthRequest()).getToken());
    }

    @Test
    void loginIsNotOk(){
        when(authenticationManager.authenticate(any())).thenThrow(new RuntimeException());
        assertNull(authService.login(generateAuthRequest()).getToken());
    }

    private AuthRequest generateAuthRequest() {
        return AuthRequest.builder()
                .email("test@gmail.com")
                .password("123456")
                .build();
    }
}
