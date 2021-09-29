package ua.kma.spring.schedule.schedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kma.spring.schedule.schedule.entities.SpecialityEntity;

public interface SpecialityRepository extends JpaRepository<SpecialityEntity, Long> {
}
