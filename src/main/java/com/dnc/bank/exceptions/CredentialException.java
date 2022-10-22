package com.dnc.bank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class CredentialException extends RuntimeException {
    public CredentialException(String message) {
        super(message);
    }
}
