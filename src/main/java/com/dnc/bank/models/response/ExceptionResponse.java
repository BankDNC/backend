package com.dnc.bank.models.response;

import lombok.Getter;

import java.util.Date;

@Getter
public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String path;
    private String httpCodeMessage;
    private Integer httpCode;

    public ExceptionResponse(Date timestamp, String message, String path,String httpCodeMessage, Integer httpCode) {
        this.timestamp = timestamp;
        this.message = message;
        this.path = path;
        this.httpCodeMessage=httpCodeMessage;
        this.httpCode=httpCode;
    }
}
