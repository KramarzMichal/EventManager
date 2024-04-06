package pl.event.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.event.manager.entity.Event;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends JpaRepository <Event, Long> {
    @Query(value ="SELECT * FROM events WHERE event_start_date >:present", nativeQuery = true)
    List<Event> findFutureEvents(LocalDateTime present);

}
