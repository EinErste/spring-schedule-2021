package ua.edu.ukma.schedule.services.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.edu.ukma.schedule.model.User;
import ua.edu.ukma.schedule.repositories.UserRepository;
import ua.edu.ukma.schedule.services.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl extends AbstractCRUDService<User> implements UserService {

    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }
    public Optional<User> findUserByEmail(String email){
        return ((UserRepository)repository).findUserByEmail(email);
    }

}