package mk.finki.ukim.mk.lab.repository.impl;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Category;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryEventRepository {
    public List<Event> findAll() {
        return DataHolder.eventList;
    }

    public List<Event> searchEvents(String text, double rating) {
        return DataHolder.eventList.stream().filter(r->r.getName().equals(text) && r.getPopularityScore()<=rating).toList();
    }

    public Optional<Event> findById(Long id) {
        return DataHolder.eventList.stream().filter(r->r.getId().equals(id)).findFirst();
    }

    public Optional<Event> findByName(String name) {
        return DataHolder.eventList.stream().filter(r->r.getName().equals(name)).findFirst();
    }

    public void deleteById(Long id) {
        DataHolder.eventList.removeIf(r->r.getId().equals(id));
    }

    public Optional<Event> saveOrUpdate(String name, String description, double popularityScore, Location location, Category category) {
        DataHolder.eventList.removeIf(r->r.getName().equals(name));
        Event event = new Event(name, description, popularityScore, location, category);
        DataHolder.eventList.add(event);
        return Optional.of(event);
    }
}
