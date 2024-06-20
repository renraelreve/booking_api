package sctp.ntu.booking_api.serviceImpls;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import sctp.ntu.booking_api.entities.Booking;
import sctp.ntu.booking_api.entities.Event;
import sctp.ntu.booking_api.entities.Showtime;
import sctp.ntu.booking_api.entities.User;
import sctp.ntu.booking_api.repositories.BookingRepository;
import sctp.ntu.booking_api.repositories.EventRepository;
import sctp.ntu.booking_api.repositories.ShowtimeRepository;
import sctp.ntu.booking_api.repositories.UserRepository;
import sctp.ntu.booking_api.services.BookingService;

@Component
public class DataLoader {

  private UserRepository userRepository;
  private BookingRepository bookingRepository;
  private ShowtimeRepository showtimeRepository;
  private EventRepository eventRepository;
  private BookingService bookingService;

  @Autowired
  public DataLoader(UserRepository userRepository, BookingRepository bookingRepository,
      ShowtimeRepository showtimeRepository, EventRepository eventRepository, BookingService bookingService) {
    this.bookingRepository = bookingRepository;
    this.showtimeRepository = showtimeRepository;
    this.userRepository = userRepository;
    this.eventRepository = eventRepository;
    this.bookingService = bookingService;

  }

  @PostConstruct
  public void loadData() {
    // Clear the database first
    userRepository.deleteAll();
    showtimeRepository.deleteAll();
    bookingRepository.deleteAll();
    eventRepository.deleteAll();

    // Load user data
    User tony = new User("Tony", "tony@me.com", "password");
    User bruce = new User("Bruce", "bruce@me.com", "password");
    User peter = new User("Peter", "peter@me.com", "password");
    User stephen = new User("Stephen", "stephen@me.com", "password");

    userRepository.save(tony);
    userRepository.save(bruce);
    userRepository.save(peter);
    userRepository.save(stephen);

    // Load event data
    Event event1 = new Event("Music Concert");
    Event event2 = new Event("Tech Conference");

    eventRepository.save(event1);
    eventRepository.save(event2);

    // Load showtime data associated with events
    Showtime showtime1 = new Showtime(100, LocalDate.of(2024, 6, 6), 100);
    showtime1.setEvent(event1);
    Showtime showtime2 = new Showtime(150, LocalDate.of(2024, 7, 7), 150);
    showtime2.setEvent(event1);
    Showtime showtime3 = new Showtime(200, LocalDate.of(2024, 8, 8), 200);
    showtime3.setEvent(event2);
    Showtime showtime4 = new Showtime(250, LocalDate.of(2024, 9, 9), 250);
    showtime4.setEvent(event2);

    showtimeRepository.save(showtime1);
    showtimeRepository.save(showtime2);
    showtimeRepository.save(showtime3);
    showtimeRepository.save(showtime4);

    // Load booking data using bookingService.addBooking to ensure balance seats are
    // updated
    Booking booking1 = new Booking();
    booking1.setBookedSeats(20);
    bookingService.addBooking(tony.getId(), showtime1.getId(), booking1);

    Booking booking2 = new Booking();
    booking2.setBookedSeats(30);
    bookingService.addBooking(tony.getId(), showtime2.getId(), booking2);

    Booking booking3 = new Booking();
    booking3.setBookedSeats(1);
    bookingService.addBooking(peter.getId(), showtime3.getId(), booking3);

    Booking booking4 = new Booking();
    booking4.setBookedSeats(4);
    bookingService.addBooking(stephen.getId(), showtime4.getId(), booking4);
  }
}
