package sctp.ntu.booking_api.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "booking")
@Getter
@Setter

public class Booking {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "bid")
  private int bid;

  @Column(name = "booked-seats")
  private int bookedSeats;

  @JsonBackReference(value = "user-booking")
  @ManyToOne(optional = false)
  @JoinColumn(name = "user_name", referencedColumnName = "name")
  @JoinColumn(name = "user_email", referencedColumnName = "email")
  private User user;

  @JsonBackReference(value = "showtime-booking")
  @ManyToOne(optional = false)
  @JoinColumn(name = "showtime_id", referencedColumnName = "sid")
  @JoinColumn(name = "showtime_date", referencedColumnName = "date")
  @JoinColumn(name = "showtime_total_seats", referencedColumnName = "total_seats")
  private Showtime showtime;

}
