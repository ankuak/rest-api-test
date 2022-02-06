
package com.paypal.bfs.test.bookingserv.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.dao.BookingEntity;
import com.paypal.bfs.test.bookingserv.dao.BookingRepository;
import com.paypal.bfs.test.bookingserv.exception.BookingException;

import junit.framework.TestCase;

@RunWith(MockitoJUnitRunner.class)
public class BookingServiceTest extends TestCase {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingService bookingService = new BookingServiceImpl();

    @Test
    public void testCreateBooking() throws Exception {

        Booking booking = new Booking();

        booking.setFirstName("test");
        booking.setLastName("test");

        booking.setDateOfBirth("1990-08-08");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd KK:mm:ss");
        Date checkin = simpleDateFormat.parse("2021-08-08 13:49:51");
        Date checkout = simpleDateFormat.parse("2021-08-09 12:00:00");

        booking.setCheckIn(checkin);
        booking.setCheckOut(checkout);

        booking.setDeposit(1000);
        booking.setTotalPrice(5000);

        Address address = new Address();
        address.setLine1("test");
        address.setCity("test");
        booking.setAddress(address);

        BookingEntity bookingDAO = new BookingEntity();
        bookingDAO.setFirstName(booking.getFirstName());
        bookingDAO.setLastName(booking.getLastName());
        bookingDAO.setDateOfBirth(booking.getDateOfBirth());
        bookingDAO.setCheckIn(booking.getCheckIn());

        Mockito.when(bookingRepository.save(Mockito.any())).thenReturn(bookingDAO);

        bookingService.create(booking, "test");

        Mockito.verify(bookingRepository).save(Mockito.any(BookingEntity.class));
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testCheckInGreaterThanCheckout() throws Exception {

        Booking booking = new Booking();

        booking.setFirstName("test");
        booking.setLastName("test");

        booking.setDateOfBirth("1990-08-08");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd KK:mm:ss");
        Date checkin = simpleDateFormat.parse("2021-08-10 13:49:51");
        Date checkout = simpleDateFormat.parse("2021-08-09 12:00:00");

        booking.setCheckIn(checkin);
        booking.setCheckOut(checkout);

        exceptionRule.expect(BookingException.class);
        exceptionRule.expectMessage("Check in date can not be greater than checkout date");

        bookingService.create(booking, "test");
    }

    @Test
    public void testGetAllBookings() {
        bookingService.getAllBookings();
        Mockito.verify(bookingRepository).findAll();
    }
}