package sctp.ntu.booking_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sctp.ntu.booking_api.entities.User;
import sctp.ntu.booking_api.entities.Booking;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    // Custom query to find all customers with a certain first name
    List<User> findByName(String name);
    User findOneByName(String name);

}
