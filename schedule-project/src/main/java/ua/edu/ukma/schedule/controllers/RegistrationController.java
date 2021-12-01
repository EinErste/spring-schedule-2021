package ua.edu.ukma.schedule.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.edu.ukma.schedule.model.Staff;
import ua.edu.ukma.schedule.model.Student;
import ua.edu.ukma.schedule.services.PasswordService;
import ua.edu.ukma.schedule.services.StaffService;
import ua.edu.ukma.schedule.services.StudentService;
import ua.edu.ukma.schedule.services.UserService;

import static ua.edu.ukma.schedule.util.ConstantsUtil.*;

@Controller
public class RegistrationController {

    private final UserService userService;
    private final PasswordService passwordService;
    private final StudentService studentService;
    private final StaffService staffService;

    @Autowired
    public RegistrationController(UserService userService, PasswordService passwordService, StudentService studentService, StaffService staffService) {
        this.userService = userService;
        this.passwordService = passwordService;
        this.studentService = studentService;
        this.staffService = staffService;
    }


    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("user", new Student());
        model.addAttribute(ERROR_LABEL, null);
        return SIGNUP_LABEL;
    }


    @PostMapping("/signup-processing")
    public String signupStudent(@ModelAttribute Student student, Model model) {
        if (userService.findUserByEmail(student.getEmail()).isPresent()) {
            model.addAttribute(ERROR_LABEL, "Student has already existed");
            return SIGNUP_LABEL;
        } else {
            student.setPassword(passwordService.encodePassword(student.getPassword()));
            model.addAttribute("user", studentService.save(student));
            model.addAttribute(SUCCESS_LABEL, "Successfully registered, please log in");
            return LOGIN_LABEL;
        }
    }
    @GetMapping("/addStaff")
    public String addStaff(Model model) {
        model.addAttribute("user", new Staff());
        model.addAttribute(ERROR_LABEL, null);
        return ADD_STAFF_LABEL;
    }


    @PostMapping("/addStaff-processing")
    public String signupStaff(@ModelAttribute Staff staff, Model model) {
        if (userService.findUserByEmail(staff.getEmail()).isPresent()) {
            model.addAttribute(ERROR_LABEL, "Staff has already existed");
        } else {
            staff.setPassword(passwordService.encodePassword(staff.getPassword()));
            model.addAttribute("user", staffService.save(staff));
            model.addAttribute(SUCCESS_LABEL, "Successfully registered");
        }
        return ADD_STAFF_LABEL;
    }
}
