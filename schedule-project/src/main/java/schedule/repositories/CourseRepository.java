package schedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import schedule.entities.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
}
