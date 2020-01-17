package com.bae.bookingsystem.exceptions;

import javax.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "That customer was not found in the database.")
public class CustomerNotFoundException extends EntityNotFoundException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

}