package test.rest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.bae.bookingsystem.persistance.domain.Booking;
import com.bae.bookingsystem.rest.BookingController;
import com.bae.bookingsystem.service.BookingService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * BookingServiceTest
 */
@RunWith(MockitoJUnitRunner.class)
public class BookingControllerTest {

    @InjectMocks
    private BookingController bookingController;

    @Mock
    private BookingService bookingService;
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
    public void postBookingTest() {
        when(this.bookingService.createBooking(testBooking)).thenReturn(confirmedBooking);
        assertEquals(this.confirmedBooking, this.bookingController.postBooking(testBooking));
        verify(this.bookingService, times(1)).createBooking(this.testBooking);
    }

    @Test
    public void findBookingByIdTest() {
        when(this.bookingService.findBooking(this.id)).thenReturn(this.confirmedBooking);
        assertEquals(this.confirmedBooking, this.bookingController.findBooking(this.id));
        verify(this.bookingService, times(1)).findBooking(this.id);
    }

    @Test
    public void findAllBookingsTest() {
        when(this.bookingService.readBookings()).thenReturn(this.bookings);
        assertEquals(bookings, this.bookingController.findAllBookings());
        verify(this.bookingService, times(1)).readBookings();
    }

}