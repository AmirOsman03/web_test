package mk.finki.ukim.mk.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.service.EventBookingService;
import mk.finki.ukim.mk.lab.service.EventService;
import mk.finki.ukim.mk.lab.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EventBookingController {
    private final EventBookingService eventBookingService;
    private final EventService eventService;
    private final UserService userService;


    public EventBookingController(EventBookingService eventBookingService, EventService eventService, UserService userService) {
        this.eventBookingService = eventBookingService;
        this.eventService = eventService;
        this.userService = userService;
    }

    @GetMapping("/eventBooking")
    public String showBookingPage(Model model) {
        // Додај ја логиката за прикажување на настаните ако е потребно
        return "booking"; // Претпоставуваме дека "booking.html" е формата за настани
    }



    @PostMapping("/eventBooking")
    public String booking(@RequestParam String eventName,
                          @RequestParam String numTickets,
                          Model model) {

        String name = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getName();
        String ipAddress = "127.0.0.1";

        EventBooking booking = eventBookingService.placeBooking(eventName, name, ipAddress, Long.parseLong(numTickets));
        model.addAttribute("eventBooking", booking);

        return "booking";
    }
}
