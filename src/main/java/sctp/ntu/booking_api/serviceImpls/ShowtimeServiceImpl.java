package sctp.ntu.booking_api.serviceImpls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sctp.ntu.booking_api.entities.Booking;
import sctp.ntu.booking_api.entities.Showtime;
import sctp.ntu.booking_api.exceptions.ShowtimeNotFoundException;
import sctp.ntu.booking_api.repositories.BookingRepository;
import sctp.ntu.booking_api.repositories.ShowtimeRepository;
import sctp.ntu.booking_api.services.ShowtimeService;

@Service
public class ShowtimeServiceImpl implements ShowtimeService {
  private ShowtimeRepository showtimeRepository;
  private BookingRepository bookingRepository;

  @Autowired
  public ShowtimeServiceImpl(ShowtimeRepository showtimeRepository, BookingRepository bookingRepository) {
    this.showtimeRepository = showtimeRepository;
    this.bookingRepository = bookingRepository;
  }

  @Override
  public Showtime createShowtime(Showtime showtime) {
    Showtime newShowtime = showtimeRepository.save(showtime);
    return newShowtime;
  }

  @Override
  public ArrayList<Showtime> getAllShowtimes() {
    List<Showtime> allShowtimes = showtimeRepository.findAll();
    return (ArrayList<Showtime>) allShowtimes;
  }

  @Override
  public Showtime getShowtime(int sid) {
    return showtimeRepository.findById(sid).orElseThrow(() -> new ShowtimeNotFoundException(sid));
  }

  @Override
  public Showtime updateShowtime(int sid, Showtime showtime) {
    Showtime showtimeToUpdate = showtimeRepository.findById(sid).orElseThrow(() -> new ShowtimeNotFoundException(sid));
    showtimeToUpdate.setTotalSeats(showtime.getTotalSeats());
    showtimeToUpdate.setDate(showtime.getDate());
    return showtimeRepository.save(showtimeToUpdate);
  }

  @Override
  public void deleteShowtime(int sid) {
    showtimeRepository.deleteById(sid);
  }

  @Override
  public Booking addBookingToShowtime(int sid, Booking booking) {
    Showtime selectedShowtime = showtimeRepository.findById(sid).orElseThrow(() -> new ShowtimeNotFoundException(sid));

    booking.setShowtime(selectedShowtime);
    return bookingRepository.save(booking);
  }

}
