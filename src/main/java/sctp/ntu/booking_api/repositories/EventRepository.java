package sctp.ntu.booking_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sctp.ntu.booking_api.entities.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {

}
