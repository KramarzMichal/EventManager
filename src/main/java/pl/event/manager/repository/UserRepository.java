package pl.event.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.event.manager.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
