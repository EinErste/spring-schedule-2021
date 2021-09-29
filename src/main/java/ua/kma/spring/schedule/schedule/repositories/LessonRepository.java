package ua.kma.spring.schedule.schedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kma.spring.schedule.schedule.entities.LessonEntity;

public interface LessonRepository extends JpaRepository<LessonEntity, Long> {
}
