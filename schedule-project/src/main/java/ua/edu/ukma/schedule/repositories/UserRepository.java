package ua.edu.ukma.schedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.ukma.schedule.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
