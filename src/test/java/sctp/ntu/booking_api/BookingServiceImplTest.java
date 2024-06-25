package sctp.ntu.booking_api;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import sctp.ntu.booking_api.entities.Booking;
import sctp.ntu.booking_api.entities.User;
import sctp.ntu.booking_api.entities.Showtime;
import sctp.ntu.booking_api.exceptions.BookingNotFoundException;
import sctp.ntu.booking_api.exceptions.UserNotFoundException;
import sctp.ntu.booking_api.exceptions.ShowtimeNotFoundException;
import sctp.ntu.booking_api.repositories.BookingRepository;
import sctp.ntu.booking_api.repositories.UserRepository;
import sctp.ntu.booking_api.serviceImpls.BookingServiceImpl;
import sctp.ntu.booking_api.repositories.ShowtimeRepository;
import sctp.ntu.booking_api.services.ShowtimeService;

public class BookingServiceImplTest {

    // Mock to declare testing that is isolated
    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ShowtimeRepository showtimeRepository;

    @Mock
    private ShowtimeService showtimeService;

    @InjectMocks //injecting mocks into BookingServiceImpl to test
    private BookingServiceImpl bookingServiceImpl;

    @BeforeEach //initiallise the mock before each testing method
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateBooking_Valid() {
        //SETUP
        Showtime showtime = new Showtime();
        User user = new User();  
        Booking booking = new Booking(showtime, user, 2);
        when(bookingRepository.save(any(Booking.class))).thenReturn(booking); 
        //EXECUTE
        Booking createdBooking = bookingServiceImpl.createBooking(showtime, user, 2); 
        //ASSERT
        assertNotNull(createdBooking); 
        assertEquals(2, createdBooking.getBookedSeats()); 
    }

    @Test
    public void testFindBookingByBid_Valid() {
        //SETUP
        Booking booking = new Booking();
        //MOCK
        when(bookingRepository.findBookingByBid(anyInt())).thenReturn(booking);
        //EXECUTE
        Booking foundBooking = bookingServiceImpl.findBookingByBid(1);   
        //ASSERT
        assertNotNull(foundBooking); 
    }

    @Test
    public void testGetAllBookings() {
        //SETUP
        List<Booking> bookings = new ArrayList<>(); 
        bookings.add(new Booking()); 
        //MOCK
        when(bookingRepository.findAll()).thenReturn(bookings); 
        //EXECUTE
        List<Booking> allBookings = bookingServiceImpl.getAllBookings(); 
        //ASSERT
        assertEquals(1, allBookings.size());
    }

    @Test
    public void testUpdateBooking_Valid() {
        // SETUP
        Showtime showtime = new Showtime();
        Booking booking = new Booking(showtime, new User(), 2);
        //MOCK
        when(bookingRepository.save(any(Booking.class))).thenReturn(booking);
        //EXECUTE
        Booking updatedBooking = bookingServiceImpl.updateBooking(booking, 4);
        //ASSERT
        assertEquals(4, updatedBooking.getBookedSeats());
    }

    @Test
    public void testDeleteBooking_Valid() {
        //SETUP
        Booking booking = new Booking();
        Showtime showtime = new Showtime();
        showtime.setBooking(new ArrayList<>());
        booking.setShowtime(showtime);
        //MOCK
        when(bookingRepository.findById(anyInt())).thenReturn(Optional.of(booking));
        //EXECUTE
        bookingServiceImpl.deleteBooking(1);
        //VERIFY
        verify(bookingRepository, times(1)).deleteById(1);
    }

    @Test
    public void testAddBooking_Valid() {
        //SETUP
        User user = new User();
        Showtime showtime = new Showtime();
        showtime.setBooking(new ArrayList<>()); 
        Booking booking = new Booking();
        //MOCK
        when(userRepository.findById(anyInt())).thenReturn(Optional.of(user));
        when(showtimeRepository.findById(anyInt())).thenReturn(Optional.of(showtime));
        when(bookingRepository.save(any(Booking.class))).thenReturn(booking);
        //EXECUTE
        Booking addedBooking = bookingServiceImpl.addBooking(1, 1, booking);
        //ASSERT
        assertNotNull(addedBooking);
    }
}