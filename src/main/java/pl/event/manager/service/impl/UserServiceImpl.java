package pl.event.manager.service.impl;



import org.springframework.stereotype.Service;
import pl.event.manager.entity.User;
import pl.event.manager.repository.UserRepository;
import pl.event.manager.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository, UserDetailsManager userDetailsManager) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User userToSave) {
     return userRepository.save(encodePassword(userToSave));

    }

    private static User encodePassword (User user) {
        String password = new BCryptPasswordEncoder(20).encode(user.getPassword());
        user.setPassword(password);
        return user;
    }

    @Override
    public User updateUser(User userToUpdate) {
        return userRepository.save(encodePassword(userToUpdate));
    }

    @Override
    public boolean deleteUserById(long id) {
        userRepository.findById(id).orElseThrow(()-> new RuntimeException("Użytkownik nie znaleziony!"));
        userRepository.deleteById(id);
        return userRepository.findById(id).isEmpty();
    }

}
