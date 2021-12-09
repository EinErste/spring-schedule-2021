package ua.edu.ukma.schedule.services;

import ua.edu.ukma.schedule.model.User;

import java.util.Collection;
import java.util.Optional;

public interface UserService extends CRUDService<User> {
    Optional<User> findUserByEmail(String email);

    Collection<User> getSearched(String query);
}
