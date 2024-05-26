package com.example.be.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.xml.crypto.Data;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class DataIsDefinedException extends RuntimeException{
    public DataIsDefinedException(String message) {
        super(message);
    }
}
