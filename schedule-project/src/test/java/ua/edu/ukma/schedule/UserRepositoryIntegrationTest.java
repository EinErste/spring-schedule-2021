package ua.edu.ukma.schedule;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import ua.edu.ukma.schedule.model.User;
import ua.edu.ukma.schedule.repositories.UserRepository;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenFindByEmailAndUserExistsThenReturnUser() {
        User testUser = User.builder().email("taisiia@example.com").name("Taisiia"). surname("Shutiak").password("pass").build();
        entityManager.persist(testUser);
        entityManager.flush();
        Optional<User> foundUser = userRepository.findUserByEmail("taisiia@example.com");
        assertThat(foundUser.get().getName())
                .isEqualTo(testUser.getName());
        assertThat(foundUser.get().getSurname())
                .isEqualTo(testUser.getSurname());
        assertThat(foundUser.get().getEmail())
                .isEqualTo(testUser.getEmail());
        assertThat(foundUser.get().getPassword())
                .isEqualTo(testUser.getPassword());
    }
    @Test
    public void whenFindByEmailAndUserNotExistsThenReturnOptionalWithNull() {
        Optional<User> foundUser = userRepository.findUserByEmail("taisiia@example.com");
        assertThat(foundUser.isPresent())
                .isEqualTo(false);
    }
}
