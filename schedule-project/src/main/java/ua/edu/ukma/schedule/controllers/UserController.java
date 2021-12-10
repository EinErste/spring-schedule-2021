package ua.edu.ukma.schedule.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import ua.edu.ukma.schedule.model.*;
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
        if(isStudent)
            model.addAttribute("formLink", "/editStudent-processing");
        else
            model.addAttribute("formLink", "/editStaff-processing");

        if(isStudent)
            model.addAttribute("user", (Student)user);
        else if(isMethodist)
            model.addAttribute("user", (Staff)user);
        else
            model.addAttribute("user", user);


//        model.addAttribute("adminSelected", user.getPermissions().get(0).getPermission().equals(Permissions.PermissionName.ADMIN));
//
//        model.addAttribute("methodistSelected", user.getPermissions().get(0).getPermission().equals(Permissions.PermissionName.METHODIST));
//        model.addAttribute("studentSelected", user.getPermissions().get(0).getPermission().equals(Permissions.PermissionName.STUDENT));

        return USER_EDIT_LABEL;
    }

    @PostMapping("/editStudent-processing")
    public String editStudent(@ModelAttribute Student newUser, Model model) {
        User user = userService.getById(newUser.getId());
        newUser.setPassword(user.getPassword());
        newUser.setPermissions(user.getPermissions());
        model.addAttribute("user", userService.editUser(newUser));
        model.addAttribute(SUCCESS_LABEL, "User edited successfully");
        return REDIRECT_LABEL;
    }

    @PostMapping("/editStaff-processing")
    public String editStaff(@ModelAttribute Staff newUser, Model model) {
        User user = userService.getById(newUser.getId());
        newUser.setPassword(user.getPassword());
        newUser.setPermissions(user.getPermissions());
        model.addAttribute("user", userService.editUser(newUser));
        model.addAttribute(SUCCESS_LABEL, "User edited successfully");
        return REDIRECT_LABEL;
    }

}
