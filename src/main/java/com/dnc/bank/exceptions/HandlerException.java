package com.dnc.bank.exceptions;

import com.dnc.bank.models.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

//@ControllerAdvice
//@RestController
@RestControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler({EmailExistException.class, NitExistException.class})
    public final ResponseEntity<ExceptionResponse> handleEmailExistException(RuntimeException ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        ExceptionResponse exceptionResponseDto = ExceptionResponse.builder()
                .timestamp(new Date())
                .message(ex.getMessage())
                .path(request.getDescription(false))
                .httpCodeMessage(status.getReasonPhrase())
                .httpCode(status.value())
                .build();

        return new ResponseEntity<>(exceptionResponseDto, status);
    }

    @ExceptionHandler(CredentialException.class)
    public final ResponseEntity<ExceptionResponse> handleCredentialException(RuntimeException ex, WebRequest request) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;

        ExceptionResponse exceptionResponseDto = ExceptionResponse.builder()
                .timestamp(new Date())
                .message(ex.getMessage())
                .path(request.getDescription(false))
                .httpCodeMessage(status.getReasonPhrase())
                .httpCode(status.value())
                .build();

        return new ResponseEntity<>(exceptionResponseDto, status);
    }

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundException(RuntimeException ex, WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        ExceptionResponse exceptionResponseDto = ExceptionResponse.builder()
                .timestamp(new Date())
                .message(ex.getMessage())
                .path(request.getDescription(false))
                .httpCodeMessage(status.getReasonPhrase())
                .httpCode(status.value())
                .build();

        return new ResponseEntity<>(exceptionResponseDto, status);
    }

}
