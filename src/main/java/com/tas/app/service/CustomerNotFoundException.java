package com.tas.app.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Vladimir Vashchuk on 30.05.2018
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException {

    CustomerNotFoundException(String message) {
        super(message);
    }
}
