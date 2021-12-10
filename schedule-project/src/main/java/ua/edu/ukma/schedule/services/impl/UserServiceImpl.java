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

import java.util.Collection;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends AbstractCRUDService<User> implements UserService, UserDetailsService {

    public UserServiceImpl(JpaRepository<User, Long> repository) {
        super(repository);
    }

    public Optional<User> findUserByEmail(String email) {
        return getRepository().findUserByEmail(email);
    }

    @Override
    public Collection<User> getSearched(final String query) {
        String preparedQuery = query.toLowerCase(Locale.getDefault());
        return getRepository()
                .findAll()
                .stream()
                .filter(user -> user.getEmail().toLowerCase().contains(preparedQuery) || user.getEmail().toLowerCase().contains(preparedQuery)
                || user.getName().toLowerCase().contains(preparedQuery) || user.getSurname().toLowerCase().contains(preparedQuery)
                || user.getPermissions().stream().anyMatch(p->p.getPermission().toString().toLowerCase().contains(preparedQuery)))
                .collect(Collectors.toList());
    }

    @Override
    public User editUser(User user){
        repository.saveAndFlush(user);
        return user;
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