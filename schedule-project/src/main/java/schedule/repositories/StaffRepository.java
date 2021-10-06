package schedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import schedule.entities.StaffEntity;

public interface StaffRepository extends JpaRepository<StaffEntity, Long> {
}
