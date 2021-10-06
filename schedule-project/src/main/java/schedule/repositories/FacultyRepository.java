package schedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import schedule.entities.FacultyEntity;

public interface FacultyRepository extends JpaRepository<FacultyEntity, Long> {
}
