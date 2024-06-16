package sctp.ntu.booking_api.services;

import java.util.ArrayList;

import sctp.ntu.booking_api.entities.User;
// import sctp.ntu.booking_api.entities.Interaction;

public interface UserService {

  User createUser(User user);

  // User getUser(Long uid);

  ArrayList<User> getAllUsers();

  // User updateUser(Long uid, User user);

  // void deleteUserr(Long uid);

  // ArrayList<User> searchUsers(String name);
}
