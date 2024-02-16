package com.proyecto.Crudfutbolclub.NotFundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFundException extends RuntimeException{
    
    private static final long serialVersionUID = 6518669326214254361L;

    public NotFundException(String message) {
        super(message);
    }
}
