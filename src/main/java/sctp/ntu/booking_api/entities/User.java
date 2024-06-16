package sctp.ntu.booking_api.entities;

import java.util.List;
import java.util.UUID;

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
  @Column(name = "id")
  private Long uid;

  @Column(name = "name")
  @NotBlank(message = "Name is mandatory")
  private String name;

  @Email(message = "Email should be valid")
  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

  // @OneToMany(mappedBy = "booking")
  // private List<Booking> booking;

  // public User() {
  // }

  public User() {

  }

  public User(String name, String email, String password) {
    this();
    this.name = name;
    this.email = email;
    this.password = password;
  }
}
