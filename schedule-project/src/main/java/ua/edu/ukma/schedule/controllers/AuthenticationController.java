package ua.edu.ukma.schedule.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ua.edu.ukma.schedule.model.Student;
import ua.edu.ukma.schedule.model.User;
import ua.edu.ukma.schedule.services.PasswordService;
import ua.edu.ukma.schedule.services.StudentService;
import ua.edu.ukma.schedule.services.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static ua.edu.ukma.schedule.util.ConstantsUtil.*;

@Controller
public class AuthenticationController {

    private final UserService userService;
    private final PasswordService passwordService;

    @Autowired
    public AuthenticationController(UserService userService, PasswordService passwordService) {
        this.userService = userService;
        this.passwordService = passwordService;
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute(ERROR_LABEL, null);
        return LOGIN_LABEL;
    }

    @PostMapping("/login-processing")
    public String loginUser(@ModelAttribute User user, Model model) {

        Optional<User> foundUserOptional = userService.findUserByEmail(user.getEmail());
        User foundUser;
        if (foundUserOptional.isEmpty()) {
            model.addAttribute(ERROR_LABEL, "User doesn't exists");
            return LOGIN_LABEL;
        } else {
            foundUser = foundUserOptional.get();
        }

        if (!passwordService.compareRawAndEncodedPassword(user.getPassword(), (foundUser.getPassword()))) {
            model.addAttribute(ERROR_LABEL, "Wrong password");
            return LOGIN_LABEL;
        }

        return "redirect:/";
    }

}
