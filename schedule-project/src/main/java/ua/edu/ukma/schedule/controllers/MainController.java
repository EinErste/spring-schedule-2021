package ua.edu.ukma.schedule.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
@RequiredArgsConstructor
@Log4j2
public class MainController {

    private final UserService userService;

    private final StudentService studentService;

    @GetMapping("/index")
    public String login() {
        return INDEX_LABEL;
    }

    @GetMapping("/student-schedule")
    public String studentSchedule(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        var wrapped = userService.findUserByEmail(username);

        if(wrapped.isPresent()){
            Student student = studentService.getById(wrapped.get().getId());
            log.error(student.getLessons());
            model.addAttribute("lessons",student.getLessons());
            return STUDENT_SCHEDULE_LABEL;
        } else {
            return "redirect:/";
        }
    }
}
