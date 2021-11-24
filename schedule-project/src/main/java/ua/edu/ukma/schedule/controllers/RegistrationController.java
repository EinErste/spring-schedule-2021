package ua.edu.ukma.schedule.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.edu.ukma.schedule.model.Student;
import ua.edu.ukma.schedule.services.PasswordService;
import ua.edu.ukma.schedule.services.StudentService;
import ua.edu.ukma.schedule.services.UserService;

import static ua.edu.ukma.schedule.util.ConstantsUtil.*;

@Controller
public class RegistrationController {

    private final UserService userService;
    private final PasswordService passwordService;
    private final StudentService studentService;

    @Autowired
    public RegistrationController(UserService userService, PasswordService passwordService, StudentService studentService) {
        this.userService = userService;
        this.passwordService = passwordService;
        this.studentService = studentService;
    }


    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("user", new Student());
        model.addAttribute(ERROR_LABEL, null);
        return SIGNUP_LABEL;
    }


    @PostMapping("/signup-processing")
    public String signupStudent(@ModelAttribute Student student, Model model) {
        if (!userService.findUserByEmail(student.getEmail()).isEmpty()) {
            model.addAttribute(ERROR_LABEL, "Student has already existed");
            return SIGNUP_LABEL;
        } else {
            student.setPassword(passwordService.encodePassword(student.getPassword()));
            model.addAttribute("user", studentService.save(student));
            model.addAttribute(SUCCESS_LABEL, "Successfully registered, please log in");
            return LOGIN_LABEL;
        }
    }
}
