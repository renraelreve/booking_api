package sctp.ntu.booking_api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import sctp.ntu.booking_api.entities.User;
import sctp.ntu.booking_api.entities.Booking;

public interface UserService {
    
    User createUser(User user);

    User getUser(Integer uid);

    ArrayList<User> getAllUsers();

    User updateUser(Integer uid, User user);

    void deleteUser(Integer uid);

    ArrayList<User> searchUser(String name);
    
    User findOneUser(String name);
    
}
