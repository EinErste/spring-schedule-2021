package schedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import schedule.entities.SpecialityEntity;

public interface SpecialityRepository extends JpaRepository<SpecialityEntity, Long> {
}
