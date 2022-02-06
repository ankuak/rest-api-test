package com.paypal.bfs.test.bookingserv.api;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1/bfs/booking")
public interface BookingResource {
    /**
     * Create {@link Booking} resource
     * 
     * sample request body 
     * {"first_name": "AK", "last_name": "kumar", "date_of_birth": "1990-08-08", "check_in": "2021-08-08", "check_out": "2021-08-09", "total_price": "4353", "deposit": "34534", "address": { "line1":"line1 of address", "line2":"line1 of address", "city":"Bangalore", "state":"Karnataka", "country": "india", "zip_code": 560103 } }
     *
     * @param booking the booking object
     * @return the created booking
     */
    @PostMapping
    ResponseEntity<Booking> create(@RequestBody Booking booking, @RequestHeader("idempotency-key") String idempotencyKey)
            throws Exception;

    @GetMapping
    @ResponseBody
    ResponseEntity<Iterable<Booking>> getAllBookings();
}

