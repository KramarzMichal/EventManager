package pl.event.manager.service;

import pl.event.manager.entity.Event;

public interface EventService {
    Event saveEvent(Event eventToSave);

    Event updateEvent(Event eventToUpdate);

    Event updateEvent(long id, Event eventToUpdate);

    Event addComment(String comment);

}
