package sctp.ntu.booking_api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sctp.ntu.booking_api.entities.Event;
import sctp.ntu.booking_api.entities.Showtime;
import sctp.ntu.booking_api.services.EventService;

@RestController
@RequestMapping("/events")
public class EventController {

  private EventService eventService;

  public EventController(EventService eventService) {
    this.eventService = eventService;
  }

  @PostMapping("")
  public ResponseEntity<Event> createEvent(@RequestBody Event event) {
    Event newEvent = eventService.createEvent(event);
    return new ResponseEntity<>(newEvent, HttpStatus.CREATED);
  }

  @GetMapping("")
  public ResponseEntity<List<Event>> getAllEvents() {
    List<Event> events = eventService.getAllEvents();
    return new ResponseEntity<>(events, HttpStatus.OK);
  }

  @GetMapping("/{eid}")
  public ResponseEntity<Event> getEvent(@PathVariable int eid) {
    Event foundEvent = eventService.getEvent(eid);
    return new ResponseEntity<>(foundEvent, HttpStatus.OK);
  }

  @PutMapping("/{eid}")
  public ResponseEntity<Event> updateEvent(@PathVariable int eid, @RequestBody Event event) {
    Event updatedEvent = eventService.updateEvent(eid, event);
    return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
  }

  @DeleteMapping("/{eid}")
  public ResponseEntity<Void> deleteEvent(@PathVariable int eid) {
    eventService.deleteEvent(eid);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PostMapping("/{eid}/showtimes")
  public ResponseEntity<Showtime> addShowtimetoEvent(@PathVariable int eid, @RequestBody Showtime showtime) {
    Showtime newShowtime = eventService.addShowtimetoEvent(eid, showtime);
    return new ResponseEntity<>(newShowtime, HttpStatus.CREATED);
  }
}
