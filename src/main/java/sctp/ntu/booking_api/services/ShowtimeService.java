package sctp.ntu.booking_api.services;

import java.util.ArrayList;

import sctp.ntu.booking_api.entities.Booking;
import sctp.ntu.booking_api.entities.Showtime;

public interface ShowtimeService {

  Showtime createShowtime(Showtime showtime);

  Showtime getShowtime(int sid);

  ArrayList<Showtime> getAllShowtimes();

  Showtime updateShowtime(int sid, Showtime showtime);

  void deleteShowtime(int sid);

  Booking addBookingToShowtime(int sid, Booking booking);
}
