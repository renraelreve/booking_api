package sctp.ntu.booking_api.serviceImpls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sctp.ntu.booking_api.entities.Booking;
import sctp.ntu.booking_api.entities.User;
import sctp.ntu.booking_api.exceptions.UserNotFoundException;
import sctp.ntu.booking_api.repositories.UserRepository;
import sctp.ntu.booking_api.repositories.BookingRepository;
import sctp.ntu.booking_api.services.UserService;

@Service
public class UserServiceImpl implements UserService {
  private UserRepository userRepository;
  private BookingRepository bookingRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository, BookingRepository bookingRepository) {
    this.userRepository = userRepository;
    this.bookingRepository = bookingRepository;
  }

  @Override
  public User createUser(User user) {
    User newUser = userRepository.save(user);
    return newUser;
  }

  @Override
  public ArrayList<User> getAllUsers() {
    List<User> allUsers = userRepository.findAll();
    return (ArrayList<User>) allUsers;
  }

  @Override
  public User getUser(int id) {
    // Optional<Customer> optionalCustomer = customerRepository.findById(id);
    // if(optionalCustomer.isPresent()) {
    // Customer foundCustomer = optionalCustomer.get();
    // return foundCustomer;
    // }
    // throw new CustomerNotFoundException(id);
    return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
  }

  @Override
  public User updateUser(int uid, User user) {
    User userToUpdate = userRepository.findById(uid).orElseThrow(() -> new UserNotFoundException(uid));
    userToUpdate.setName(user.getName());
    userToUpdate.setEmail(user.getEmail());
    userToUpdate.setPassword(user.getPassword());
    return userRepository.save(userToUpdate);
  }

  @Override
  public void deleteUser(int uid) {
    userRepository.deleteById(uid);
  }

  @Override
  public Booking addBookingToUser(int uid, Booking booking) {
    User selectedUser = userRepository.findById(uid).orElseThrow(() -> new UserNotFoundException(uid));

    booking.setUser(selectedUser);
    return bookingRepository.save(booking);
  }

}
