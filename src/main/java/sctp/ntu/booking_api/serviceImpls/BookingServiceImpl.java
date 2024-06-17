package sctp.ntu.booking_api.serviceImpls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sctp.ntu.booking_api.entities.Booking;
import sctp.ntu.booking_api.exceptions.BookingNotFoundException;
import sctp.ntu.booking_api.repositories.BookingRepository;
import sctp.ntu.booking_api.services.BookingService;

@Service
public class BookingServiceImpl implements BookingService {
  private BookingRepository bookingRepository;

  @Autowired
  public BookingServiceImpl(BookingRepository bookingRepository) {
    this.bookingRepository = bookingRepository;
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

    bookingToUpdate.setBookingDate(booking.getBookingDate());
    bookingToUpdate.setBookedSeats(booking.getBookedSeats());

    return bookingRepository.save(booking);
  }

  @Override
  public void deleteBooking(int bid) {
    bookingRepository.deleteById(bid);
  }
}
