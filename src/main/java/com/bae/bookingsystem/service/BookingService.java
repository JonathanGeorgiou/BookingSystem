package com.bae.bookingsystem.service;

import java.util.List;

import com.bae.bookingsystem.persistance.domain.Booking;
import com.bae.bookingsystem.persistance.repo.BookingRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//timeOfBooking 

/**
 * BookingService
 */
@Service
public class BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    public Booking createBooking(Booking booking) {
        return bookingRepo.save(booking);
    }

    public Booking findBooking(Long id) {
        return this.bookingRepo.findById(id).get();
    }

    public List<Booking> readBookings() {
        return this.bookingRepo.findAll();
    }

    public Booking updateBooking(Booking booking, Long id) {
        Booking bookingToUpdate = findBooking(id);
        bookingToUpdate.setStyle(booking.getStyle());
        bookingToUpdate.setTimeOfBooking(booking.getTimeOfBooking());
        return this.bookingRepo.save(bookingToUpdate);
    }

    public String deleteBooking(Long id) {
        this.bookingRepo.deleteById(id);
        return "Booking succesfully deleted.";
    }

}