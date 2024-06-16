package sctp.ntu.booking_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sctp.ntu.booking_api.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
