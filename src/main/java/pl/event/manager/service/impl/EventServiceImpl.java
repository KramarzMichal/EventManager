package pl.event.manager.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import pl.event.manager.entity.Comment;
import pl.event.manager.entity.Event;
import pl.event.manager.repository.CommentRepository;
import pl.event.manager.repository.EventRepository;
import pl.event.manager.service.EventService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

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
        Optional<Event> foundEvent = eventRepository.findById(eventToUpdate.getId());
        if (foundEvent.isPresent()) {
            throw new IllegalArgumentException("Event not found!");
        } else return eventRepository.save(eventToUpdate);
    }

    @Override
    public Event updateEvent(long eventId, Event eventToUpdate) {
        Optional<Event> foundEvent = eventRepository.findById(eventId);
        if (foundEvent.isPresent()) {
            throw new IllegalArgumentException("Event not found!");
        } else return eventRepository.save(eventToUpdate);
    }

    @Override
    public Event addComment(long eventId, String comment) {
        Comment newComment = commentRepository.save(new Comment(0L, comment));
        return eventRepository.findById(eventId)
                .map(event -> {
                    event.getEventComments().add(newComment.getId());
                    return eventRepository.save(event);
                })
                .orElseThrow(() -> new EntityNotFoundException("Event o nr id: " + eventId + " nie został znaleziony"));
    }



    @Override
    public void deleteEventById(long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public List<Event> getFutureEvents() {
        LocalDateTime present = LocalDateTime.of(LocalDate.now(),LocalTime.now());
        return eventRepository.findFutureEvents(present);
    }


}
