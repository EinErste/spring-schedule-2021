package ua.edu.ukma.schedule.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import ua.edu.ukma.schedule.model.Student;
import ua.edu.ukma.schedule.services.StudentService;
import ua.edu.ukma.schedule.util.CustomResponse;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
@Log4j2
public class StudentController {

    private final StudentService studentService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public CustomResponse<Long> create(
            @RequestBody @Valid Student user
    ) {
        return CustomResponse.of(studentService.save(user).getId());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CustomResponse<Student> read(
            @PathVariable(value = "id") Long id
    ) {
        return CustomResponse.of(studentService.getById(id));
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public CustomResponse<Boolean> update(
            @RequestBody @Valid Student user
    ) {
        studentService.save(user);
        return CustomResponse.of(true);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public CustomResponse<Boolean> delete(
            @PathVariable(value = "id") Long id
    ) {
        studentService.delete(id);
        return CustomResponse.of(true);
    }
}
