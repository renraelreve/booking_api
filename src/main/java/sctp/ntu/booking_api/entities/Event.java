package sctp.ntu.booking_api.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity

public class Event {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "eid")
  private int eid;

  @Column(name = "description")
  @NotBlank(message = "description is mandatory")
  private String description;

  @JsonBackReference(value = "event-showtime")
  @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
  private List<Showtime> showtimes;

  public Event() {
  }

  public Event(String description) {
    this.description = description;
  }
}
