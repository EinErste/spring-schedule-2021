package ua.edu.ukma.schedule.services.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.edu.ukma.schedule.model.User;
import ua.edu.ukma.schedule.repositories.UserRepository;
import ua.edu.ukma.schedule.services.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl extends AbstractCRUDService<User> implements UserService, UserDetailsService {

    public UserServiceImpl(JpaRepository<User, Long> repository) {
        super(repository);
    }

    public Optional<User> findUserByEmail(String email) {
        return getRepository().findUserByEmail(email);
    }

    @Override
    @Cacheable(cacheNames = "username")
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        return getRepository().findUserByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("No user with email: " + username));
    }

    public long count() {
        return repository.count();
    }

    private UserRepository getRepository() {
        return (UserRepository) repository;
    }
}