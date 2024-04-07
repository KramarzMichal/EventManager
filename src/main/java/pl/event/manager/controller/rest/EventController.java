package pl.event.manager.controller.rest;

import org.springframework.web.bind.annotation.*;
import pl.event.manager.entity.Comment;
import pl.event.manager.entity.Event;
import pl.event.manager.service.EventService;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<Event> getFutureEvents(){
        return eventService.getFutureEvents();
    }

    @PostMapping("/api/evests/{id}")
    public Event addComment (@PathVariable long id, @RequestBody String comment){
        return eventService.addComment(id, comment);
    }


}
