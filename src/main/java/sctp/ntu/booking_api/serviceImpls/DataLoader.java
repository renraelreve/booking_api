package sctp.ntu.booking_api.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import sctp.ntu.booking_api.entities.User;
import sctp.ntu.booking_api.repositories.UserRepository;

@Component
public class DataLoader {
  private UserRepository userRepository;

  @Autowired
  public DataLoader(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @PostConstruct
  public void loadData() {
    // clear the database first
    userRepository.deleteAll();

    // load data here
    userRepository.save(new User("Tony", "tony@me.com", "password"));
    userRepository.save(new User("Bruce", "bruce@me.com", "password"));
    userRepository.save(new User("Peter", "peter@me.com", "password"));
    userRepository.save(new User("Stephen", "stephen@me.com", "password"));

  }
}
