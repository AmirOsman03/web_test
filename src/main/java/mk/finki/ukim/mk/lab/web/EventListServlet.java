//package mk.finki.ukim.mk.lab.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.finki.ukim.mk.lab.model.Event;
//import mk.finki.ukim.mk.lab.service.impl.EventServiceImpl;
//import org.thymeleaf.context.IWebContext;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet()
//public class EventListServlet extends HttpServlet {
//    private final EventServiceImpl eventService;
//    private final SpringTemplateEngine engine;
//
//    public EventListServlet(EventServiceImpl eventService, SpringTemplateEngine engine) {
//        this.eventService = eventService;
//        this.engine = engine;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<Event> eventList = eventService.listAll();
//
//        IWebExchange exchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);
//        WebContext context = new WebContext(exchange);
//
//        context.setVariable("events", eventList);
//
//        engine.process("listEvents.html", context, resp.getWriter());
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        String category = req.getParameter("category");
//
//        if (!name.isEmpty()) {
//            double rating = Double.parseDouble(req.getParameter("rating"));
//            req.getSession().setAttribute("eventList", eventService.searchEvents(name, rating));
//            resp.sendRedirect("/");
//        }
//    }
//}
