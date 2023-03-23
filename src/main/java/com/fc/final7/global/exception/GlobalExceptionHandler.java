package com.fc.final7.global.exception;

import com.fc.final7.global.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateKeyException.class)
    protected ResponseEntity<ErrorResponse> handleDuplicateKeyException(DuplicateKeyException e){
        log.error("DuplicateKeyException", e);
        ErrorResponse response = ErrorResponse.of(ErrorCode.DUPLICATE_ID);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
