package ru.krylosov.arkadiy.controller;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import ru.krylosov.arkadiy.config.ThymeleafConfig;
import ru.krylosov.arkadiy.dao.daoImplementation.EventDaoImpl;
import ru.krylosov.arkadiy.model.Event;
import ru.krylosov.arkadiy.model.File;
import ru.krylosov.arkadiy.service.EventService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet({"/event", "/event/get", "/event/list", "/event/save", "/event/update", "/event/delete"})
public class EventController extends HttpServlet {

    private ThymeleafConfig thymeleafConfig;
    private ServletContext servletContext;
    private EventService eventService;

    @Override
    public void init(ServletConfig config) {
        servletContext = config.getServletContext();
        thymeleafConfig = new ThymeleafConfig(servletContext);
        eventService = new EventService(new EventDaoImpl());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        String action = req.getServletPath();

        switch (action) {
            case "/event/get":
                getById(req,resp);
            case "/event/save":
                save(req, resp);
                break;
            case "/event/list":
                getAll(req, resp);
                break;
            case "/event/update":
                update(req, resp);
                break;
            case "/event/delete":
                deleteById(req,resp);
                break;

        }

    }

    public void getById(HttpServletRequest req, HttpServletResponse resp) {
        WebContext context = new WebContext(req, resp, servletContext, req.getLocale());
        Long id = Long.parseLong(req.getParameter("id"));
        Event event = eventService.getById(id);
        context.setVariable("event", event);

        TemplateEngine engine = thymeleafConfig.getTemplateEngine();
        try{
            engine.process("event/get", context, resp.getWriter());
        } catch (IOException exception){
            System.out.println("Error occurred " + exception.getMessage());
        }
    }

    public void getAll(HttpServletRequest req, HttpServletResponse resp) {
        WebContext context = new WebContext(req, resp, servletContext, req.getLocale());
        List<Event> events = eventService.getAll();
        context.setVariable("events", events);

        TemplateEngine engine = thymeleafConfig.getTemplateEngine();
        try {
            engine.process("event/list", context, resp.getWriter());
        } catch (IOException exception) {
            System.out.println("Error occurred " + exception.getMessage());
        }
    }

    public void save(HttpServletRequest req, HttpServletResponse resp) {
        WebContext context = new WebContext(req, resp, servletContext, req.getLocale());
        TemplateEngine engine = thymeleafConfig.getTemplateEngine();
        try {
            engine.process("event/new", context, resp.getWriter());
        } catch (IOException exception) {
            System.out.println("Error occurred " + exception.getMessage());
        }
    }

    public void update(HttpServletRequest req, HttpServletResponse resp) {
        Long id = Long.parseLong(req.getParameter("id"));
        String file = req.getParameter("file");
        eventService.update(eventService.getById(id));
        try {
            resp.sendRedirect("/event");
        } catch (IOException exception) {
            System.out.println("Error occurred " + exception.getMessage());
        }
    }

    public void deleteById(HttpServletRequest req, HttpServletResponse resp) {
        Long id = Long.parseLong(req.getParameter("id"));
        eventService.deleteById(id);
        try {
            resp.sendRedirect("/event");
        } catch (IOException exception){
            System.out.println("Error occurred " + exception.getMessage());
        }
    }
}
