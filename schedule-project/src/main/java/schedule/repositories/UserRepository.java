package schedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import schedule.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
