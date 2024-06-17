package sctp.ntu.booking_api.services;

import java.util.ArrayList;

import sctp.ntu.booking_api.entities.Booking;
import sctp.ntu.booking_api.entities.User;
// import sctp.ntu.booking_api.entities.Interaction;

public interface UserService {

  User createUser(User user);

  User getUser(int uid);

  ArrayList<User> getAllUsers();

  User updateUser(int uid, User user);

  void deleteUser(int uid);

  Booking addBookingToUser(int uid, Booking booking);

  // ArrayList<User> searchUsers(String name);
}
