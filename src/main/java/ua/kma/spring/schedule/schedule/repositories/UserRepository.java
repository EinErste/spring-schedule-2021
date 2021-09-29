package ua.kma.spring.schedule.schedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kma.spring.schedule.schedule.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
