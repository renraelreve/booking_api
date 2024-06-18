package sctp.ntu.booking_api.serviceImpls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sctp.ntu.booking_api.entities.Event;
import sctp.ntu.booking_api.entities.Showtime;
import sctp.ntu.booking_api.exceptions.EventNotFoundException;
import sctp.ntu.booking_api.repositories.EventRepository;
import sctp.ntu.booking_api.repositories.ShowtimeRepository;
import sctp.ntu.booking_api.services.EventService;

@Service
public class EventServiceImpl implements EventService {
  private EventRepository eventRepository;
  private ShowtimeRepository showtimeRepository;

  @Autowired
  public EventServiceImpl(EventRepository eventRepository, ShowtimeRepository showtimeRepository) {
    this.eventRepository = eventRepository;
    this.showtimeRepository = showtimeRepository;
  }

  @Override
  public Event createEvent(Event event) {
    Event newEvent = eventRepository.save(event);
    return newEvent;
  }

  @Override
  public ArrayList<Event> getAllEvents() {
    List<Event> allEvents = eventRepository.findAll();
    return (ArrayList<Event>) allEvents;
  }

  @Override
  public Event getEvent(int eid) {
    return eventRepository.findById(eid).orElseThrow(() -> new EventNotFoundException(eid));
  }

  @Override
  public Event updateEvent(int eid, Event event) {
    Event eventToUpdate = eventRepository.findById(eid).orElseThrow(() -> new EventNotFoundException(eid));
    eventToUpdate.setDescription(event.getDescription());
    return eventRepository.save(eventToUpdate);
  }

  @Override
  public void deleteEvent(int eid) {
    eventRepository.deleteById(eid);
  }

  @Override
  public Showtime addShowtimetoEvent(int eid, Showtime showtime) {
    Event selectedEvent = eventRepository.findById(eid).orElseThrow(() -> new EventNotFoundException(eid));

    showtime.setEvent(selectedEvent);
    return showtimeRepository.save(showtime);
  }
}
