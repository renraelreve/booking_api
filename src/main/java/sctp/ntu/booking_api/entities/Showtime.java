package sctp.ntu.booking_api.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "showtime")

public class Showtime {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "sid")
  private int sid;

  @Column(name = "total_seats")
  private int totalSeats;

  // @Transient
  // private int balanceSeats;

  @Column(name = "balance_seats")
  private int balanceSeats;

  @Column(name = "date")
  private LocalDate date;

  @OneToMany(mappedBy = "showtime", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonManagedReference(value = "showtime-booking")
  private List<Booking> bookings;

  @JsonBackReference(value = "event-showtime")
  @ManyToOne(optional = false)
  @JoinColumn(name = "description", referencedColumnName = "description")
  private Event event;

  public Showtime() {
  }

  public Showtime(int totalSeats, LocalDate date, int balance_seats) {
    this.totalSeats = totalSeats;
    this.date = date;
    this.balanceSeats = balance_seats;
  }

  public int getId() {
    return sid;
  }

  // @PostLoad
  // private void calculateBalanceSeats() {
  // int totalSeats = getTotalSeats();
  // int bookedSeats = 0;
  // for (Booking booking : bookings) {
  // bookedSeats += booking.getBookedSeats();
  // }
  // setBalanceSeats(totalSeats - bookedSeats);
  // }

}
