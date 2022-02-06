package com.paypal.bfs.test.bookingserv.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<BookingEntity, Integer> {

}
