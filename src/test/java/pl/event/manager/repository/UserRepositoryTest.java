package pl.event.manager.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pl.event.manager.entity.User;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    private User user;

    @BeforeEach
    void setUp() {
        user = new User(1L, "Jan Kowalski", "kowalski@gmail.com", "password");
    }
    @Test
    @DisplayName("Zapisywanie użytkownika")
    void shouldSaveUser(){
        //given
        //when
        User savedUser = userRepository.save(user);
        //then
        assertThat(savedUser).isEqualTo(user);
    }
}