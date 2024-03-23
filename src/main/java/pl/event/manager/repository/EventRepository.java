package pl.event.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.event.manager.entity.Event;

public interface EventRepository extends JpaRepository <Event, Long> {
}
