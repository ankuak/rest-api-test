package com.paypal.bfs.test.bookingserv.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.model.Booking;

@RestController
public class BookingResourceImpl implements BookingResource {
	
	@Autowired
	BookingService bookingService;

	@Override
	public ResponseEntity<Booking> create(Booking booking, String idempotencyKey) throws Exception {
		return new ResponseEntity<>(bookingService.create(booking, idempotencyKey), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Iterable<Booking>> getAllBookings() {
		return new ResponseEntity<>(bookingService.getAllBookings(), HttpStatus.OK);
	}
}
