package ua.edu.ukma.schedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.ukma.schedule.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
