package schedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import schedule.entities.LessonEntity;

public interface LessonRepository extends JpaRepository<LessonEntity, Long> {
}
