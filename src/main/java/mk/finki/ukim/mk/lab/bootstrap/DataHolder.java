package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Category;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.model.enumerations.Role;
import mk.finki.ukim.mk.lab.repository.jpa.CategoryRepository;
import mk.finki.ukim.mk.lab.repository.jpa.EventRepository;
import mk.finki.ukim.mk.lab.repository.jpa.LocationRepository;
import mk.finki.ukim.mk.lab.repository.jpa.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Event> eventList = new ArrayList<>(10);
    public static List<User> userList = new ArrayList<>(10);
    public static List<Category> categoryList = new ArrayList<>(10);
    public static List<Location> locationList = new ArrayList<>(10);

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final LocationRepository locationRepository;
    private final EventRepository eventRepository;
    private final PasswordEncoder passwordEncoder;



    public DataHolder(UserRepository userRepository, CategoryRepository categoryRepository, LocationRepository locationRepository, EventRepository eventRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.locationRepository = locationRepository;
        this.eventRepository = eventRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init() {
        if (this.userRepository.count() == 0) {
            userList.add(new User("amir", passwordEncoder.encode("amir"), "Amir", "Amir", Role.ROLE_USER));
            userList.add(new User("admin", passwordEncoder.encode("admin"), "admin", "admin", Role.ROLE_ADMIN));
            this.userRepository.saveAll(userList);
        }

        Category sport = new Category("Sport");
        Category fashion = new Category("Fashion");
        Category education = new Category("Education");

        if (this.categoryRepository.count() == 0) {
            categoryList.add(sport);
            categoryList.add(fashion);
            categoryList.add(education);
            this.categoryRepository.saveAll(categoryList);
        }

        Location skopje = new Location("Skopje", "brsjacka buna", "120", "Desc1");
        Location tetovo = new Location("Tetovo", "Ulica tetovo", "150", "Desc2");
        Location kumanovo = new Location("Kumanovo", "Ulica tetovo", "150", "Desc2");

        if (this.locationRepository.count() == 0) {
            locationList.add(skopje);
            locationList.add(tetovo);
            locationList.add(kumanovo);
            this.locationRepository.saveAll(locationList);
        }

        if (this.eventRepository.count() == 0) {
            eventList.add(new Event("Event 1", "Desc 1", 150.0, skopje, sport));
            eventList.add(new Event("Event 2", "Desc 2", 100.0, kumanovo, fashion));
            eventList.add(new Event("Event 3", "Desc 3", 250.0, tetovo, education));
            this.eventRepository.saveAll(eventList);
        }
    }

    //da se napravi kategorija za sekoj event i da se napravi filter za listanje na tie kategorii so koristenje na servlets i thymeleaf
    //primer muzicka kategorija da ima kopce i koga ke se stisne da izlezat eventite na taa muzicka kategorija
}
