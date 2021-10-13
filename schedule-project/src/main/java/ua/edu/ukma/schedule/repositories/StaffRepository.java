package ua.edu.ukma.schedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.ukma.schedule.model.Staff;

public interface StaffRepository extends JpaRepository<Staff, Long> {
}
