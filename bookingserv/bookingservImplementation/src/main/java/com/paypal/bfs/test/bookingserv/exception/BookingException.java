package com.paypal.bfs.test.bookingserv.exception;

import org.springframework.http.HttpStatus;

public class BookingException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private final HttpStatus httpStatus;

    public BookingException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public BookingException(String message, HttpStatus httpStatus, Exception e) {
        super(message, e);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
