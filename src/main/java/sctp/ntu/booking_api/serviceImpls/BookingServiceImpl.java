package sctp.ntu.booking_api.serviceImpls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sctp.ntu.booking_api.entities.Booking;
import sctp.ntu.booking_api.entities.Showtime;
import sctp.ntu.booking_api.entities.User;
import sctp.ntu.booking_api.exceptions.BookingNotFoundException;
import sctp.ntu.booking_api.exceptions.ShowtimeNotFoundException;
import sctp.ntu.booking_api.exceptions.UserNotFoundException;
import sctp.ntu.booking_api.repositories.BookingRepository;
import sctp.ntu.booking_api.repositories.ShowtimeRepository;
import sctp.ntu.booking_api.repositories.UserRepository;
import sctp.ntu.booking_api.services.BookingService;

@Service
public class BookingServiceImpl implements BookingService {
  private BookingRepository bookingRepository;
  private UserRepository userRepository;
  private ShowtimeRepository showtimeRepository;

  @Autowired
  public BookingServiceImpl(BookingRepository bookingRepository, UserRepository userRepository,
      ShowtimeRepository showtimeRepository) {
    this.bookingRepository = bookingRepository;
    this.userRepository = userRepository;
    this.showtimeRepository = showtimeRepository;
  }

  @Override
  public Booking createBooking(Booking booking) {
    return bookingRepository.save(booking);
  }

  @Override
  public Booking getBooking(int bid) {
    return bookingRepository.findById(bid).orElseThrow(() -> new BookingNotFoundException(bid));
  }

  @Override
  public ArrayList<Booking> getAllBookings() {
    return (ArrayList<Booking>) bookingRepository.findAll();
  }

  @Override
  public Booking updateBooking(int bid, Booking booking) {
    Booking bookingToUpdate = bookingRepository.findById(bid).orElseThrow(() -> new BookingNotFoundException(bid));

    bookingToUpdate.setBookedSeats(booking.getBookedSeats());

    return bookingRepository.save(bookingToUpdate);
  }

  @Override
  public void deleteBooking(int bid) {
    bookingRepository.deleteById(bid);
  }

  @Override
  public Booking addBooking(int uid, int sid, Booking booking) {
    User user = userRepository.findById(uid).orElseThrow(() -> new UserNotFoundException(uid));
    Showtime showtime = showtimeRepository.findById(sid).orElseThrow(() -> new ShowtimeNotFoundException(sid));

    booking.setUser(user);
    booking.setShowtime(showtime);

    return bookingRepository.save(booking);
  }
}
