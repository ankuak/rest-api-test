package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.exception.BookingException;

public interface BookingService {
	
	Booking create(Booking booking, String idempotencyKey) throws BookingException;
	
	Iterable<Booking> getAllBookings();

}
