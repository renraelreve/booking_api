package sctp.ntu.booking_api.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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

  @Column(name = "date")
  private LocalDate date;

  @OneToMany(mappedBy = "showtime", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonManagedReference(value = "showtime-booking")
  private List<Booking> bookings;

  public Showtime() {
  }

  public Showtime(int totalSeats, LocalDate date) {
    this.totalSeats = totalSeats;
    this.date = date;
  }

}
