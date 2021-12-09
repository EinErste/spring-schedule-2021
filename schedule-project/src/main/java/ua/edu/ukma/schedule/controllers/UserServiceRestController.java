package ua.edu.ukma.schedule.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.ukma.schedule.model.User;
import ua.edu.ukma.schedule.services.UserService;
import ua.edu.ukma.schedule.util.CustomResponse;

import java.util.Optional;
@RestController
@RequiredArgsConstructor
public class UserServiceRestController {
    private final UserService userService;

    @DeleteMapping(value = "users/{id}")
    public CustomResponse<Boolean> delete(@PathVariable String id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<User> wrapped = userService.findUserByEmail(username);
        if(wrapped.isPresent()){
            if(Long.valueOf(id).equals(wrapped.get().getId()))
                return CustomResponse.of(false);
        }
        userService.delete(Long.valueOf(id));
        return userService.existsById(Long.valueOf(id)) ? CustomResponse.of(false) : CustomResponse.of(true);
    }
}
