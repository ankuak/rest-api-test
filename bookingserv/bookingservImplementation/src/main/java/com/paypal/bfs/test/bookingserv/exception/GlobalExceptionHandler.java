package com.paypal.bfs.test.bookingserv.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookingException.class)
    protected ResponseEntity<Object> handleBookingException(BookingException bookingException) {
        return new ResponseEntity<>(bookingException.getMessage(), bookingException.getHttpStatus());
    }
}
