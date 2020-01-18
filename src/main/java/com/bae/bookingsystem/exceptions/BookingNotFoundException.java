package com.bae.bookingsystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Booking not in the database.")
public class BookingNotFoundException extends EntityNotFoundException {

    private static final long serialVersionUID = -2590687720244290021L;
}
