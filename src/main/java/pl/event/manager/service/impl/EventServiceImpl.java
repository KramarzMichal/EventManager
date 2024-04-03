package pl.event.manager.service.impl;

import org.springframework.stereotype.Service;
import pl.event.manager.entity.Event;
import pl.event.manager.repository.CommentRepository;
import pl.event.manager.repository.EventRepository;
import pl.event.manager.service.EventService;
@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final CommentRepository commentRepository;

    public EventServiceImpl(EventRepository eventRepository, CommentRepository commentRepository) {
        this.eventRepository = eventRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public Event saveEvent(Event eventToSave) {
        return null;
    }

    @Override
    public Event updateEvent(Event eventToUpdate) {
        return null;
    }

    @Override
    public Event updateEvent(long id, Event eventToUpdate) {
        return null;
    }

    @Override
    public Event addComment(String comment) {
        return null;
    }

    @Override
    public void deleteEventById(long id) {

    }
}
