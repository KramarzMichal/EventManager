package pl.event.manager.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.event.manager.entity.Event;
import pl.event.manager.service.EventService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<Event> getFutureEvents(){
        return eventService.getFutureEvents();
    }

}
