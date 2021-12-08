package ua.edu.ukma.schedule.services.impl;

import org.springframework.cache.annotation.CachePut;
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

    private final UserRepository userRepository;

    public UserServiceImpl(JpaRepository<User, Long> repository) {
        super(repository);
        this.userRepository = (UserRepository) repository;
    }

    public Optional<User> findUserByEmail(String email) {
        return ((UserRepository) repository).findUserByEmail(email);
    }

    @Override
    @Cacheable(cacheNames = "username")
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("No user with email: " + username));

        user.getPermissions().forEach(System.out::println);
        return user;
    }

    public long count(){
        return ((UserRepository) repository).count();
    }


}