package ua.edu.ukma.schedule.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ua.edu.ukma.schedule.model.Permissions;
import ua.edu.ukma.schedule.model.Staff;
import ua.edu.ukma.schedule.model.Student;
import ua.edu.ukma.schedule.model.User;
import ua.edu.ukma.schedule.services.UserService;

import static ua.edu.ukma.schedule.util.ConstantsUtil.*;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public String getUsers(Model model, @RequestParam(required = false) String query) {
        model.addAttribute("users", query == null ? userService.getAll() : userService.getSearched(query));
        model.addAttribute("query", query);
        return USER_LIST_LABEL;
    }

    @GetMapping("/users/{id}")
    public String getUserInfo(Model model, @PathVariable Long id) {
        User user = userService.getById(id);
        boolean isStudent = user instanceof Student;
        boolean isMethodist = user instanceof Staff;
        model.addAttribute("isStudent", isStudent);
        model.addAttribute("isMethodist", isMethodist);
        model.addAttribute("year", isStudent ? ((Student) user).getYear() : -1);
        model.addAttribute("position", isMethodist ? ((Staff) user).getPosition() : -1);
        model.addAttribute("user", user);
       return  USER_LABEL;
    }

    @GetMapping("/users/edit/{id}")
    public String getUserInfoEdit(Model model, @PathVariable Long id) {
        User user = userService.getById(id);
        boolean isStudent = user instanceof Student;
        boolean isMethodist = user instanceof Staff;
        model.addAttribute("isStudent", isStudent);
        model.addAttribute("isMethodist", isMethodist);
        model.addAttribute("year", isStudent ? ((Student) user).getYear() : "");
        model.addAttribute("position", isMethodist ? ((Staff) user).getPosition() : "");
        model.addAttribute("user", user);
        model.addAttribute("adminSelected", user.getPermissions().get(0).getPermission().equals(Permissions.PermissionName.ADMIN));

        model.addAttribute("methodistSelected", user.getPermissions().get(0).getPermission().equals(Permissions.PermissionName.METHODIST));
        model.addAttribute("studentSelected", user.getPermissions().get(0).getPermission().equals(Permissions.PermissionName.STUDENT));

        return USER_EDIT_LABEL;
    }


}
