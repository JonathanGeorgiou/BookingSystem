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
import com.bae.bookingsystem.persistance.domain.Customer;
import com.bae.bookingsystem.persistance.repo.CustomerRepo;
import com.bae.bookingsystem.service.CustomerService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * CustomerServiceTest
 */

@RunWith(SpringRunner.class)
public class CustomerServiceTest {

    @InjectMocks
    private CustomerService custService;

    @Mock
    private CustomerRepo custRepo;
    private List<Customer> custList;
    private Customer testCustomer;
    private Customer confirmedCustomer;
    private Booking testBooking;
    private LocalDateTime bookingTime;
    private List<Booking> bookingList;
    final long id = 1L;

    @Before
    public void initialiser() {
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
    public void createCustomerTest() {
        when(this.custRepo.save(testCustomer)).thenReturn(confirmedCustomer);
        assertEquals(this.confirmedCustomer, this.custService.createCustomer(testCustomer));
        verify(this.custRepo, times(1)).save(this.testCustomer);
    }

    @Test
    public void deleteCustomerTest() {
        when(this.custRepo.existsById(this.id)).thenReturn(true, false);
        this.custService.deleteCustomer(this.id);
        verify(this.custRepo, times(1)).deleteById(this.id);
        verify(this.custRepo, times(2)).existsById(this.id);
    }

    @Test
    public void findCustomerTest() {
        when(this.custRepo.findById(this.id)).thenReturn(Optional.of(this.confirmedCustomer));
        assertEquals(this.confirmedCustomer, this.custService.findCustomer(this.id));
        verify(this.custRepo, times(1)).findById(this.id);
    }

    @Test
    public void readCustomersTest() {
        when(this.custRepo.findAll()).thenReturn(this.custList);
        assertEquals(custList, this.custService.readCustomers());
        verify(this.custRepo, times(1)).findAll();
    }

    @Test
    public void updateCustomerTest() {
        Customer newCust = new Customer("Peter", "Parker", "spider-man@gmail.com", "07228392839", bookingList);
        Customer updatedCustomer = new Customer(newCust.getFirstName(), newCust.getLastName(), newCust.getEmail(),
                newCust.getPhoneNumber(), newCust.getBookings());
        updatedCustomer.setId(this.id);

        when(this.custRepo.findById(this.id)).thenReturn(Optional.of(confirmedCustomer));
        when(this.custRepo.save(updatedCustomer)).thenReturn(updatedCustomer);

        assertEquals(updatedCustomer, this.custService.updateCustomer(newCust, this.id));

        verify(this.custRepo, times(1)).findById(this.id);
        verify(this.custRepo, times(1)).save(updatedCustomer);
    }

}