package ua.edu.ukma.schedule.services.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ua.edu.ukma.schedule.model.User;
import ua.edu.ukma.schedule.repositories.UserRepository;

import java.util.LinkedList;
import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserServiceImpl service;

    @Test
    void findByEmailExists() {
        User expected = new User(1, "John", "Doe", "johndoe@gmail.com", "1234", new LinkedList<>());
        when(repository.findUserByEmail("johndoe@gmail.com")).thenReturn(of(expected));
        Optional<User> foundUser = service.findUserByEmail("johndoe@gmail.com");
        assertTrue(foundUser.isPresent());
        assertEquals(expected, foundUser.get());
    }

    @Test
    void findByEmailNotExists() {
        when(repository.findUserByEmail("johndoe@gmail.com")).thenReturn(empty());
        assertFalse(service.findUserByEmail("johndoe@gmail.com").isPresent());
    }

    @Test
    void loadByUsernameExists() {
        User expected = new User(1, "John", "Doe", "johndoe@gmail.com", "1234", new LinkedList<>());
        when(repository.findUserByEmail("johndoe@gmail.com")).thenReturn(of(expected));
        UserDetails foundUser = service.loadUserByUsername("johndoe@gmail.com");
        assertNotNull(foundUser);
    }

    @Test
    void loadByUsernameNotExists() {
        when(repository.findUserByEmail("johndoe@gmail.com")).thenReturn(empty());
        Exception exception = assertThrows(UsernameNotFoundException.class, () -> {
            service.loadUserByUsername("johndoe@gmail.com");
        });
        assertEquals("No user with email: johndoe@gmail.com", exception.getMessage());
    }
}