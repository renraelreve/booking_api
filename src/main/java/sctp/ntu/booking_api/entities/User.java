package sctp.ntu.booking_api.entities;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
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
@Table(name = "username")

public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "uid")
  private int uid;

  @Column(name = "name")
  @NotBlank(message = "Name is mandatory")
  private String name;

  @Email(message = "Email should be valid")
  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  @JsonManagedReference(value = "user-booking")
  private List<Booking> bookings;

  public User() {

  }

  public User(String name, String email, String password) {
    this();
    this.name = name;
    this.email = email;
    this.password = password;
  }

  public int getId() {
    return uid;
  }
}
