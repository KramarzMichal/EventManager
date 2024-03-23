package pl.event.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.event.manager.entity.Comment;

public interface CommentRepository extends JpaRepository <Comment, Long> {
}
