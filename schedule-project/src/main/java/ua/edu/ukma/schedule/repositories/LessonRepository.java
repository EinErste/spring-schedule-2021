package ua.edu.ukma.schedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.ukma.schedule.model.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
