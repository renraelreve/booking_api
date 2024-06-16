package sctp.ntu.booking_api.controllers;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    System.out.println("New User Created: " + newUser); // Add logging
    return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    // return new ResponseEntity<>("Test successful", HttpStatus.OK);
  }

  @GetMapping("")
  public ResponseEntity<ArrayList<User>> getAllUsers() {
    ArrayList<User> allUsers = userService.getAllUsers();
    return new ResponseEntity<>(allUsers, HttpStatus.OK);
  }

  @GetMapping("/test")
  public ResponseEntity<String> testEndpoint() {
    return new ResponseEntity<>("Test successful", HttpStatus.OK);
  }

}
