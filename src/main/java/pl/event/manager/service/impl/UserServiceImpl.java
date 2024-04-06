package pl.event.manager.service.impl;

import org.springframework.stereotype.Service;
import pl.event.manager.entity.User;
import pl.event.manager.repository.UserRepository;
import pl.event.manager.service.UserService;
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User userToSave) {
        return userRepository.save(userToSave);
    }

    @Override
    public User updateUser(User userToUpdate) {
        return userRepository.save(userToUpdate);
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }
}
