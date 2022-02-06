package com.paypal.bfs.test.bookingserv.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.dao.AddressEntity;
import com.paypal.bfs.test.bookingserv.dao.BookingEntity;
import com.paypal.bfs.test.bookingserv.dao.BookingRepository;
import com.paypal.bfs.test.bookingserv.exception.BookingException;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking create(Booking booking, String idempotencyKey) throws BookingException {

        BookingEntity bookingEntity = checkForIdempotency(idempotencyKey);
        if (bookingEntity != null)
            return buildBookingDTO(bookingEntity);

        if (booking.getCheckIn().after(booking.getCheckOut())) {
            throw new BookingException("Check in date can not be greater than checkout date ", HttpStatus.NOT_ACCEPTABLE);
        }

        BookingEntity bookingPersist = buildBookingEntity(booking, idempotencyKey);
        try {
            BookingEntity saved = bookingRepository.save(bookingPersist);
            return buildBookingDTO(saved);
        } catch (Exception e) {
            throw new BookingException("Error in saving booking ", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    /**
     * 
     * @param idempotencyKey
     * @return BookingEntity
     * 
     * idempotencyKey needs to be passed to get the data each time, can be improved
     * with ont more api to make key availablity to user or app to reconcile.
     * 
     * 
     * 
     */

    private BookingEntity checkForIdempotency(String idempotencyKey) {
        Iterable<BookingEntity> bookingDAOS = bookingRepository.findAll();

        for (BookingEntity bookingEntity : bookingDAOS) {
            if (bookingEntity.getIdempotencyKey().equals(idempotencyKey)) {
                return bookingEntity;
            }
        }
        return null;
    }

    @Override
    public Iterable<Booking> getAllBookings() {
        Iterable<BookingEntity> bookingDAOS = bookingRepository.findAll();
        List<Booking> resultDTO = new ArrayList<>();

        for (BookingEntity booking : bookingDAOS) {
            Booking bookingDTO = buildBookingDTO(booking);

            AddressEntity address = booking.getAddress();
            Address addressDTO = new Address();
            addressDTO.setCity(address.getCity());
            addressDTO.setLine1(address.getLine1());
            bookingDTO.setAddress(addressDTO);

            resultDTO.add(bookingDTO);
        }
        return resultDTO;
    }


    private Booking buildBookingDTO(BookingEntity saved) {
        Booking booking = new Booking();
        booking.setFirstName(saved.getFirstName());
        booking.setLastName(saved.getLastName());
        booking.setDateOfBirth(saved.getDateOfBirth());
        booking.setCheckIn(saved.getCheckIn());
        return booking;
    }

    private BookingEntity buildBookingEntity(Booking booking, String idempotencyKey) {
        BookingEntity bookingEntity = new BookingEntity();

        bookingEntity.setFirstName(booking.getFirstName());
        bookingEntity.setLastName(booking.getLastName());

        bookingEntity.setDateOfBirth(booking.getDateOfBirth());

        bookingEntity.setCheckIn(booking.getCheckIn());
        bookingEntity.setCheckOut(booking.getCheckOut());

        bookingEntity.setDeposit(booking.getDeposit());
        bookingEntity.setTotalPrice(booking.getTotalPrice());

        bookingEntity.setIdempotencyKey(idempotencyKey);

        AddressEntity addressEntity = buildAddressEntity(booking);
        bookingEntity.setAddress(addressEntity);
        return bookingEntity;
    }

    private AddressEntity buildAddressEntity(Booking booking) {
        Address address = booking.getAddress();
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCity(address.getCity());
        addressEntity.setLine1(address.getLine1());
        return addressEntity;
    }
}
