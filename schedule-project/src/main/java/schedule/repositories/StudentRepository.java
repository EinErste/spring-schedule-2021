package schedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import schedule.entities.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
