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
@Tag(name = "StudentController", description = "Processing operations with students")
public class StudentController {

    private final StudentService studentService;

    @Operation(
            summary = "Add new student",
            description = "Adds a new student"
    )
    @PostMapping(value = "")
    public CustomResponse<User> create(@RequestBody @Valid Student user) {
        return CustomResponse.of(studentService.save(user));
    }

    @Operation(
            summary = "Get a student",
            description = "Gets a student with given id"
    )
    @GetMapping(value = "/{id}")
    public CustomResponse<Student> read(@PathVariable(value = "id") @Parameter(description = "Student id") Long id) {
        return CustomResponse.of(studentService.getById(id));
    }

    @Operation(
            summary = "Update a student",
            description = "Updates a student"
    )
    @PutMapping(value = "")
    public CustomResponse<Student> update(@RequestBody @Valid Student user) {
        return CustomResponse.of(studentService.save(user));
    }

    @Operation(
            summary = "Delete a student",
            description = "Deletes a student"
    )
    @DeleteMapping(value = "/{id}")
    public CustomResponse<Boolean> delete(@PathVariable(value = "id") @Parameter(description = "Student id") Long id) {
        studentService.delete(id);
        return studentService.existsById(id) ? CustomResponse.of(false) : CustomResponse.of(true);
    }
}
