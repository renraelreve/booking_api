package sctp.ntu.booking_api.controllers;

import java.util.ArrayList;

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

import sctp.ntu.booking_api.entities.Showtime;
import sctp.ntu.booking_api.services.ShowtimeService;

@RestController
@RequestMapping("/showtimes")
public class ShowtimeController {

  private ShowtimeService showtimeService;

  public ShowtimeController(ShowtimeService showtimeService) {
    this.showtimeService = showtimeService;
  }

  @PostMapping("")
  public ResponseEntity<Showtime> createShowtime(@RequestBody Showtime showtime) {
    Showtime newShowtime = showtimeService.createShowtime(showtime);
    return new ResponseEntity<>(newShowtime, HttpStatus.CREATED);
  }

  @GetMapping("")
  public ResponseEntity<ArrayList<Showtime>> getAllShowtimes() {
    ArrayList<Showtime> allShowtimes = showtimeService.getAllShowtimes();
    return new ResponseEntity<>(allShowtimes, HttpStatus.OK);
  }

  @GetMapping("/{sid}")
  public ResponseEntity<Showtime> getShowtime(@PathVariable int sid) {
    Showtime foundShowtime = showtimeService.getShowtime(sid);
    return new ResponseEntity<>(foundShowtime, HttpStatus.OK);
  }

  @PutMapping("/{sid}")
  public ResponseEntity<Showtime> updateShowtime(@PathVariable int sid, @RequestBody Showtime showtime) {
    Showtime updatedShowtime = showtimeService.updateShowtime(sid, showtime);
    return new ResponseEntity<>(updatedShowtime, HttpStatus.OK);
  }

  @DeleteMapping("/{sid}")
  public ResponseEntity<Showtime> deleteShowtime(@PathVariable int sid) {
    showtimeService.deleteShowtime(sid);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
