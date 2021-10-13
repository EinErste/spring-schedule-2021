package ua.edu.ukma.schedule.services.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.edu.ukma.schedule.model.User;
import ua.edu.ukma.schedule.services.UserService;

@Service
public class UserServiceImpl extends AbstractCRUDService<User> implements UserService {

    public UserServiceImpl(JpaRepository<User, Long> repository) {
        super(repository);
    }
}