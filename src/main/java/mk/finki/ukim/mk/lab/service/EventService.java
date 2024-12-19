package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Event> listAll();
    List<Event> searchEventsByLocation_Id(Long locationId);

    Optional<Event> findById(Long id);

    Optional<Event> findByName(String name);

    Optional<Event> save(String name, String description, double popularityScore, Long locationId, Long categoryId);

    void deleteById(Long id);

    Optional<Event> update(Long id, String name, String description, double popularityScore, Long locationId, Long categoryId);

    List<Event> searchEventsByLocation_Name (Long locationId);
}
