package sctp.ntu.booking_api.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "event")
public class Event {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eid")
    private Integer eid;

    @Column(name = "description")
    public String description;

    // https://stackoverflow.com/questions/54405522/jpa-error-invaliddataaccessapiusageexception-detached-entity-passed-to-persist
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "event", cascade = CascadeType.ALL)
    private List<Showtime> showtime;

    // Constructor

    public Event(){}

    public Event(String description) {
        this();
        this.description = description;
    }

    // // // Getters and Setters
    // public Integer getId() {
    //     return eid;
    // }

    // public void setId(Integer eid) {
    //     this.eid = eid;
    // }

    // public String getDescription() {
    //     return description;
    // }

    // public void setDescription(String description) {
    //     this.description = description;
    // }
}
