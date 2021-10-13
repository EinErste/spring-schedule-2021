package ua.edu.ukma.schedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.ukma.schedule.model.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
