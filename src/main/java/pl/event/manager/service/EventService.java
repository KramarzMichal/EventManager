package pl.event.manager.service;

import pl.event.manager.entity.Event;

import java.util.List;

public interface EventService {
    Event saveEvent(Event eventToSave);

    Event updateEvent(Event eventToUpdate);

    Event updateEvent(long id, Event eventToUpdate);

    Event addComment(long eventId, String comment);

    void deleteEventById (long id);

    List<Event> getFutureEvents();
}
