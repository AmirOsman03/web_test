//package mk.finki.ukim.mk.lab.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.finki.ukim.mk.lab.model.EventBooking;
//import mk.finki.ukim.mk.lab.service.EventBookingService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet(urlPatterns = "/eventBooking")
//public class EventBookServlet extends HttpServlet {
//    private final EventBookingService bookingService;
//    private final SpringTemplateEngine engine;
//
//    public EventBookServlet(EventBookingService bookingService, SpringTemplateEngine engine) {
//        this.bookingService = bookingService;
//        this.engine = engine;
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);
//        WebContext webContext = new WebContext(webExchange);
//
//        String eventName = req.getParameter("eventName");
//        String numTickets = req.getParameter("numTickets");
//        String ipaddress = req.getRemoteAddr();
//
//        EventBooking eventBooking = bookingService.placeBooking(eventName,"Amir",ipaddress, Long.parseLong(numTickets));
//        webContext.setVariable("eventBooking", eventBooking);
//
//        engine.process("booking.html", webContext, resp.getWriter());
//    }
//}
