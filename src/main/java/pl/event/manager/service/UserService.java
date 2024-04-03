package pl.event.manager.service;

import pl.event.manager.entity.User;

public interface UserService {
    User saveUser (User userToSave);
    User updateEvent(User userToUpdate);
    User updateEvent(long id, User userToUpdate);
    void deleteEventById (long id);
}
