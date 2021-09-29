package ua.kma.spring.schedule.schedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kma.spring.schedule.schedule.entities.StaffEntity;

public interface StaffRepository extends JpaRepository<StaffEntity, Long> {
}
