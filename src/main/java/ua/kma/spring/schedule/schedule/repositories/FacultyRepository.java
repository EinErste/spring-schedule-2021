package ua.kma.spring.schedule.schedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kma.spring.schedule.schedule.entities.FacultyEntity;

public interface FacultyRepository extends JpaRepository<FacultyEntity, Long> {
}
