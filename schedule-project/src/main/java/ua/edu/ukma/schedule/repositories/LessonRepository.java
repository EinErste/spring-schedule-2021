package ua.edu.ukma.schedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.ukma.schedule.model.Lesson;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

    List<Lesson> findAllByOrderByTimeAsc();
}
