package ua.edu.ukma.schedule.controllers;

import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class MainController {

    @GetMapping("/index")
    public String login() {
        return INDEX_LABEL;
    }

}
