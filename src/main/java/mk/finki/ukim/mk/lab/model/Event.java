package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Event {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;

     String name;

     String description;

     double popularityScore;

     @ManyToOne
     Location location;

     @ManyToOne
     Category category;

     @OneToMany(mappedBy = "event")
     List<EventBooking> bookingList;

     @ManyToOne
     User user;

     public Event(String name, String description, double popularityScore, Location location, Category category) {
          this.name = name;
          this.description = description;
          this.popularityScore = popularityScore;
          this.location = location;
          this.category = category;
     }

     public Event() {}

}
