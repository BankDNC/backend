package com.dnc.bank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NitExistException extends RuntimeException {

    public NitExistException(String message) {
        super(message);
    }
}
