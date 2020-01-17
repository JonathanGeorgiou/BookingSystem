package test.rest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.bae.bookingsystem.persistance.domain.Booking;
import com.bae.bookingsystem.persistance.domain.Customer;

import com.bae.bookingsystem.rest.CustomerController;
import com.bae.bookingsystem.service.CustomerService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * CustomerServiceTest
 */

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

    @InjectMocks
    private CustomerController custController;

    @Mock
    private CustomerService custService;
    private List<Customer> custList;
    private Customer testCustomer;
    private Customer confirmedCustomer;
    private Booking testBooking;
    private LocalDateTime bookingTime;
    private List<Booking> bookingList;
    final long id = 1L;

    @Before
    public void init() {
        this.custList = new ArrayList<>();
        this.custList.add(testCustomer);
        this.bookingList = new ArrayList<>();
        this.bookingList.add(testBooking);
        this.bookingTime = LocalDateTime.of(2020, 1, 1, 13, 0);
        this.testBooking = new Booking("One Grade Clipper Cut", bookingTime);
        this.testCustomer = new Customer("Jon", "Georgiou", "jg@gmail.com", "07223872938", bookingList);
        this.confirmedCustomer = new Customer(testCustomer.getFirstName(), testCustomer.getLastName(),
                testCustomer.getEmail(), testCustomer.getPhoneNumber(), testCustomer.getBookings());
        this.confirmedCustomer.setId(id);
    }

    @Test
    public void postCustomerTest() {
        when(this.custService.createCustomer(testCustomer)).thenReturn(confirmedCustomer);
        assertEquals(this.confirmedCustomer, this.custController.postCustomer(testCustomer));
        verify(this.custService, times(1)).createCustomer(this.testCustomer);
    }

    @Test
    public void deleteCustomerTest() {
        this.custController.deleteCustomer(id);
        verify(this.custService, times(1)).deleteCustomer(id);
    }

    @Test
    public void findCustomerByIdTest() {
        when(this.custService.findCustomer(this.id)).thenReturn(this.confirmedCustomer);
        assertEquals(this.confirmedCustomer, this.custController.findCustomerById(this.id));
        verify(this.custService, times(1)).findCustomer(this.id);
    }

    @Test
    public void getAllCustomersTest() {
        when(this.custService.readCustomers()).thenReturn(this.custList);
        assertEquals(custList, this.custController.getAllCustomers());
        verify(this.custService, times(1)).readCustomers();
    }

    @Test
    public void updateCustomerTest() {
        Customer newCust = new Customer("Peter", "Parker", "spider-man@gmail.com", "07228392839", bookingList);
        Customer updatedCustomer = new Customer(newCust.getFirstName(), newCust.getLastName(), newCust.getEmail(),
                newCust.getPhoneNumber(), newCust.getBookings());
        updatedCustomer.setId(this.id);

        when(this.custService.updateCustomer(newCust, this.id)).thenReturn(updatedCustomer);

        assertEquals(updatedCustomer, this.custController.updateCustomer(this.id, newCust));

        verify(this.custService, times(1)).updateCustomer(newCust, this.id);
    }

}