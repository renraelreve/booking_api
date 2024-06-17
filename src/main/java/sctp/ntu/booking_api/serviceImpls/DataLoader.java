package sctp.ntu.booking_api.serviceImpls;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import sctp.ntu.booking_api.entities.Booking;
import sctp.ntu.booking_api.entities.Showtime;
import sctp.ntu.booking_api.entities.User;
import sctp.ntu.booking_api.repositories.BookingRepository;
import sctp.ntu.booking_api.repositories.ShowtimeRepository;
import sctp.ntu.booking_api.repositories.UserRepository;

@Component
public class DataLoader {
  private UserRepository userRepository;
  private BookingRepository bookingRepository;
  private ShowtimeRepository showtimeRepository;

  @Autowired
  public DataLoader(UserRepository userRepository, BookingRepository bookingRepository,
      ShowtimeRepository showtimeRepository) {
    this.bookingRepository = bookingRepository;
    this.showtimeRepository = showtimeRepository;
    this.userRepository = userRepository;
  }

  @PostConstruct
  public void loadData() {
    // Clear the database first
    userRepository.deleteAll();
    showtimeRepository.deleteAll();
    bookingRepository.deleteAll();

    // Load user data
    User tony = new User("Tony", "tony@me.com", "password");
    User bruce = new User("Bruce", "bruce@me.com", "password");
    User peter = new User("Peter", "peter@me.com", "password");
    User stephen = new User("Stephen", "stephen@me.com", "password");

    userRepository.save(tony);
    userRepository.save(bruce);
    userRepository.save(peter);
    userRepository.save(stephen);

    // Load showtime data
    Showtime showtime1 = new Showtime(100, LocalDate.of(2024, 6, 6));
    Showtime showtime2 = new Showtime(150, LocalDate.of(2024, 7, 7));
    Showtime showtime3 = new Showtime(200, LocalDate.of(2024, 8, 8));
    Showtime showtime4 = new Showtime(250, LocalDate.of(2024, 9, 9));

    showtimeRepository.save(showtime1);
    showtimeRepository.save(showtime2);
    showtimeRepository.save(showtime3);
    showtimeRepository.save(showtime4);

    // Load booking data
    Booking booking1 = new Booking();
    booking1.setBookedSeats(20);
    booking1.setUser(tony);
    booking1.setShowtime(showtime1);
    bookingRepository.save(booking1);

    Booking booking2 = new Booking();
    booking2.setBookedSeats(30);
    booking2.setUser(tony);
    booking2.setShowtime(showtime2);
    bookingRepository.save(booking2);

    Booking booking3 = new Booking();
    booking3.setBookedSeats(1);
    booking3.setUser(peter);
    booking3.setShowtime(showtime3);
    bookingRepository.save(booking3);

    Booking booking4 = new Booking();
    booking4.setBookedSeats(4);
    booking4.setUser(stephen);
    booking4.setShowtime(showtime4);
    bookingRepository.save(booking4);
  }

}
