package pl.event.manager.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import pl.event.manager.entity.Event;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class EventRepositoryTest {
    @Autowired
    private EventRepository eventRepository;
    private Event event;

    @BeforeEach
    void setUp() {
        event = new Event(1L,
                "Szkolenie Java",
                LocalDateTime.of(2024, 5, 5, 9, 0),
                LocalDateTime.of(2024, 12, 31, 12, 5),
                "Szkolenie z Javy prowadzone przez SDA",
                1L,
                List.of(2L, 3L, 4L), List.of(1L));
    }

    @Test
    @DisplayName("Zapisywanie eventu")
    void shouldSaveEvent() {
        //given
        //when
        Event savedEvent = eventRepository.save(event);
        //then
        assertThat(savedEvent).isNotNull();
        assertThat(savedEvent).isEqualTo(event);

    }

    @Test
    @DisplayName("Pobieranie wszystkich eventów")
    void shouldFindAllEvents() {
        //given
        Event event2 = new Event(2L,
                "Szkolenie Pythona",
                LocalDateTime.of(2024, 6, 10, 10, 30),
                LocalDateTime.of(2024, 10, 5, 16, 15),
                "Szkolenie z Pythona prowadzone przez SDA",
                5L,
                List.of(6L, 7L, 8L), List.of(2L));
        eventRepository.save(event);
        eventRepository.save(event2);
        //when
        List<Event> eventList = eventRepository.findAll();
        //then
        assertThat(eventList).isNotEmpty();
        assertThat(eventList).isNotNull();
        assertThat(eventList.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("pobieranie eventu po Id")
    void shouldFindEventById() {
        //given
        eventRepository.save(event);
        //when
        Event eventById = eventRepository.findById(event.getId()).orElse(null);
        //then
        assertThat(eventById).isNotNull();
        assertThat(eventById).isEqualTo(event);
    }
}