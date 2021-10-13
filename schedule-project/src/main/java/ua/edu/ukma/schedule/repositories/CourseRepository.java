package ua.edu.ukma.schedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.ukma.schedule.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
