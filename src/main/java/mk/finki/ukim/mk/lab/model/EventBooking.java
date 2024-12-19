package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
public class EventBooking {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     String eventName;

     String attendeeName;

     String attendeeAddress;

     Long numberOfTickets;

     @ManyToOne
     @JoinColumn(name = "event_id")
     Event event;

     public EventBooking(String eventName, String attendeeName, String attendeeAddress, Long numberOfTickets) {
          this.eventName = eventName;
          this.attendeeName = attendeeName;
          this.attendeeAddress = attendeeAddress;
          this.numberOfTickets = numberOfTickets;
     }

     public EventBooking() {}
}
