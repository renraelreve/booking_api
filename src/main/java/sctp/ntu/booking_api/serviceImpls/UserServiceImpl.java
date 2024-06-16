package sctp.ntu.booking_api.serviceImpls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sctp.ntu.booking_api.entities.User;
import sctp.ntu.booking_api.repositories.UserRepository;
import sctp.ntu.booking_api.services.UserService;

@Service
public class UserServiceImpl implements UserService {
  private UserRepository userRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
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

}
