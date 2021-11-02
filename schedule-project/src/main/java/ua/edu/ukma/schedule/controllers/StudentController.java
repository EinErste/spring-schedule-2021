package ua.edu.ukma.schedule.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name="StudentController", description="Processing operations with students")
public class StudentController {

    private final StudentService studentService;

    @Operation(
            summary = "Adding new student",
            description = "Let add a new student"
    )
    @PostMapping(value = "/")
    public CustomResponse<User> create(@RequestBody @Valid Student user) {
        return CustomResponse.of(studentService.save(user));
    }

    @Operation(
            summary = "Getting a student",
            description = "Get a student with given id"
    )
    @GetMapping(value = "/{id}")
    public CustomResponse<Student> read(@PathVariable(value = "id") @Parameter(description = "Student id")  Long id) {
        return CustomResponse.of(studentService.getById(id));
    }

    @Operation(
            summary = "Updating a student",
            description = "Let update a student"
    )
    @PutMapping(value = "/")
    public CustomResponse<Boolean> update(@RequestBody @Valid Student user) {
        studentService.save(user);
        return CustomResponse.of(true);
    }

    @Operation(
            summary = "Deleting a student",
            description = "Let delete a student"
    )
    @DeleteMapping(value = "/{id}")
    public CustomResponse<Boolean> delete(@PathVariable(value = "id") @Parameter(description = "Student id")  Long id) {
        studentService.delete(id);
        return CustomResponse.of(true);
    }
}
