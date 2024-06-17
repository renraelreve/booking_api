package sctp.ntu.booking_api.controllers;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sctp.ntu.booking_api.entities.Booking;
import sctp.ntu.booking_api.entities.User;
import sctp.ntu.booking_api.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("")
  public ResponseEntity<User> createUser(@RequestBody User user) {
    User newUser = userService.createUser(user);
    return new ResponseEntity<>(newUser, HttpStatus.CREATED);

  }

  @GetMapping("")
  public ResponseEntity<ArrayList<User>> getAllUsers() {
    ArrayList<User> allUsers = userService.getAllUsers();
    return new ResponseEntity<>(allUsers, HttpStatus.OK);
  }

  @GetMapping("/{uid}")
  public ResponseEntity<User> getCustomer(@PathVariable int uid) {
    User foundUser = userService.getUser(uid);
    return new ResponseEntity<>(foundUser, HttpStatus.OK);
  }

  @GetMapping("/test")
  public ResponseEntity<String> testEndpoint() {
    return new ResponseEntity<>("Test successful", HttpStatus.OK);
  }

  @PutMapping("/{uid}")
  public ResponseEntity<User> updateCustomer(@PathVariable int uid, @RequestBody User user) {
    User updatedUser = userService.updateUser(uid, user);
    return new ResponseEntity<>(updatedUser, HttpStatus.OK);
  }

  @DeleteMapping("/{uid}")
  public ResponseEntity<User> deleteUser(@PathVariable int uid) {
    userService.deleteUser(uid);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PostMapping("/{uid}/bookings")
  public ResponseEntity<Booking> addBookingtoUser(@PathVariable int uid, @RequestBody Booking booking) {
    Booking newBooking = userService.addBookingToUser(uid, booking);
    return new ResponseEntity<>(newBooking, HttpStatus.CREATED);
  }

}
