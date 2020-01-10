package com.bae.bookingsystem.rest;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import com.bae.bookingsystem.persistance.domain.Booking;

import com.bae.bookingsystem.service.BookingService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * BookingController
 */
@RestController
@RequestMapping
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/createBooking")
    public Booking postBooking(@RequestBody @Valid Booking booking) {
        return this.bookingService.createBooking(booking);
    }

    @GetMapping("/findAllBookings")
    public List<Booking> findAllBookings() {
        return this.bookingService.readBookings();
    }

    @GetMapping("/findBooking/{id}")
    public Booking findBooking(@PathVariable Long id) {
        return this.bookingService.findBooking(id);
    }

    @PatchMapping("/updateBooking")
    public Booking updateBooking(@PathParam("id") Long id, Booking booking) {
        return this.bookingService.updateBooking(booking, id);
    }
}
