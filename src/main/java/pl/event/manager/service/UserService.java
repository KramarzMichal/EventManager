package pl.event.manager.service;

import pl.event.manager.entity.User;

public interface UserService {
    User saveUser (User userToSave);
    User updateUser(User userToUpdate);
    boolean deleteUserById (long id);
}
