package com.dnc.bank.models.response;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String path;
    private String httpCodeMessage;
    private Integer httpCode;
}
