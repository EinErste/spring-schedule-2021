package ua.kma.spring.schedule.schedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kma.spring.schedule.schedule.entities.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
