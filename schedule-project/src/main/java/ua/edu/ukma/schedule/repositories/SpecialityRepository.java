package ua.edu.ukma.schedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.ukma.schedule.model.Speciality;

public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
}
