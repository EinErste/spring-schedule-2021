package ua.kma.spring.schedule.schedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kma.spring.schedule.schedule.entities.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
}
