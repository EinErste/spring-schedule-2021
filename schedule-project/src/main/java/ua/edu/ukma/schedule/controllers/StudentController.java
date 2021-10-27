package ua.edu.ukma.schedule.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import ua.edu.ukma.schedule.model.Student;
import ua.edu.ukma.schedule.model.User;
import ua.edu.ukma.schedule.services.StudentService;
import ua.edu.ukma.schedule.util.CustomResponse;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
@Log4j2
public class StudentController {

    private final StudentService studentService;

    @PostMapping(value = "/")
    public CustomResponse<User> create(@RequestBody @Valid Student user) {
        return CustomResponse.of(studentService.save(user));
    }

    @GetMapping(value = "/{id}")
    public CustomResponse<Student> read(@PathVariable(value = "id") Long id) {
        return CustomResponse.of(studentService.getById(id));
    }

    @PutMapping(value = "/")
    public CustomResponse<Boolean> update(@RequestBody @Valid Student user) {
        studentService.save(user);
        return CustomResponse.of(true);
    }

    @DeleteMapping(value = "/{id}")
    public CustomResponse<Boolean> delete(@PathVariable(value = "id") Long id) {
        studentService.delete(id);
        return CustomResponse.of(true);
    }
}
