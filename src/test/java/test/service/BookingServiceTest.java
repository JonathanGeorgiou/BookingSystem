package test.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bae.bookingsystem.persistance.domain.Booking;
import com.bae.bookingsystem.persistance.repo.BookingRepo;
import com.bae.bookingsystem.service.BookingService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * BookingServiceTest
 */
@RunWith(SpringRunner.class)
public class BookingServiceTest {

    @InjectMocks
    private BookingService bookingService;

    @Mock
    private BookingRepo bRepo;
    private List<Booking> bookings;
    private Booking testBooking;
    private Booking confirmedBooking;
    private LocalDateTime bookingTime;
    final Long id = 1L;

    @Before
    public void init() {
        this.bookingTime = LocalDateTime.of(2020, 1, 1, 13, 0);
        this.bookings = new ArrayList<>();
        this.testBooking = new Booking("One Grade Clipper Cut", bookingTime);
        this.bookings.add(testBooking);
        this.confirmedBooking = new Booking(this.testBooking.getStyle(), this.testBooking.getTimeOfBooking());

    }

    @Test
    public void createBookingTest() {
        when(this.bRepo.save(testBooking)).thenReturn(confirmedBooking);
        assertEquals(this.confirmedBooking, this.bookingService.createBooking(testBooking));
        verify(this.bRepo, times(1)).save(this.testBooking);
    }

    @Test
    public void findBookingTest() {
        when(this.bRepo.findById(this.id)).thenReturn(Optional.of(this.confirmedBooking));
        assertEquals(this.confirmedBooking, this.bookingService.findBooking(this.id));
        verify(this.bRepo, times(1)).findById(this.id);
    }

    @Test
    public void readBookingsTest() {
        when(this.bRepo.findAll()).thenReturn(this.bookings);
        assertEquals(bookings, this.bookingService.readBookings());
        verify(this.bRepo, times(1)).findAll();
    }

}