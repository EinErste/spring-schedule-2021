package ua.edu.ukma.schedule.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.ukma.schedule.model.User;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByEmail(String login);
}