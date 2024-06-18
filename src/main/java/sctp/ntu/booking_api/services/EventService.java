package sctp.ntu.booking_api.services;

import java.util.ArrayList;

import sctp.ntu.booking_api.entities.Event;
import sctp.ntu.booking_api.entities.Showtime;

public interface EventService {

  Event createEvent(Event event);

  Event getEvent(int eid);

  ArrayList<Event> getAllEvents();

  Event updateEvent(int eid, Event event);

  void deleteEvent(int eid);

  Showtime addShowtimetoEvent(int eid, Showtime showtime);
}
