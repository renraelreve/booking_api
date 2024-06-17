package sctp.ntu.booking_api.controllers;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sctp.ntu.booking_api.entities.Booking;
import sctp.ntu.booking_api.exceptions.BookingNotFoundException;
import sctp.ntu.booking_api.services.BookingService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/bookings")
public class BookingController {
  private BookingService bookingService;

  public BookingController(BookingService bookingService) {
    this.bookingService = bookingService;
  }

  @PostMapping("")
  public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
    Booking newBooking = bookingService.createBooking(booking);
    return new ResponseEntity<>(newBooking, HttpStatus.CREATED);

  }

  @GetMapping("")
  public ResponseEntity<ArrayList<Booking>> getAllBookings() {
    ArrayList<Booking> allBookings = bookingService.getAllBookings();
    return new ResponseEntity<>(allBookings, HttpStatus.OK);
  }

  @GetMapping("/{bid}")
  public ResponseEntity<Booking> getBooking(@PathVariable int bid) {
    try {
      Booking foundBooking = bookingService.getBooking(bid);
      return new ResponseEntity<>(foundBooking, HttpStatus.OK);
    } catch (BookingNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/{bid}")
  public ResponseEntity<Booking> updateBooking(@PathVariable int bid, @RequestBody Booking booking) {
    try {
      Booking updatedBooking = bookingService.updateBooking(bid, booking);
      return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
    } catch (BookingNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{bid}")
  public ResponseEntity<Booking> deleteBooking(@PathVariable int bid) {
    try {
      bookingService.deleteBooking(bid);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (BookingNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
