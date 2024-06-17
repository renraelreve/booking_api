package sctp.ntu.booking_api.services;

import java.util.ArrayList;

import sctp.ntu.booking_api.entities.Booking;

public interface BookingService {

  // CREATE
  Booking createBooking(Booking booking);

  // READ GET ONE
  Booking getBooking(int bid);

  // READ GET ALL
  ArrayList<Booking> getAllBookings();

  // UPDATE
  Booking updateBooking(int bid, Booking booking);

  // DELETE
  void deleteBooking(int bid);

}
