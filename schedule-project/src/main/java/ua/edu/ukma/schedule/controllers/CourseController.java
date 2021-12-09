package ua.edu.ukma.schedule.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import ua.edu.ukma.schedule.annotation.LogExecutionTime;
import ua.edu.ukma.schedule.model.Course;
import ua.edu.ukma.schedule.model.Lesson;
import ua.edu.ukma.schedule.services.CourseService;
import ua.edu.ukma.schedule.util.CustomResponse;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/course")
@Log4j2
@Tag(name = "CourseController", description = "Processing operations with courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService service;

    @Operation(
            summary = "Add new Course",
            description = "Let add a new Course"
    )
    @PostMapping(value = "/")
    public CustomResponse<Long> create(@RequestBody @Valid Course course) {
        return CustomResponse.of(service.save(course).getId());
    }

    @Operation(
            summary = "Get a Course",
            description = "Get a Course with given id"
    )
    @GetMapping(value = "/{id}")
    public CustomResponse<Course> read(@PathVariable(value = "id") @Parameter(description = "Course id") Long id) {
        Course course = service.getById(id);
        course.resolveRecursion();
        return CustomResponse.of(course);
    }

    @Operation(
            summary = "Update a Course",
            description = "Let update a Course"
    )
    @PutMapping(value = "/")
    public CustomResponse<Boolean> update(@RequestBody @Valid Course course) {
        service.save(course);
        return CustomResponse.of(true);
    }

    @Operation(
            summary = "Delete a Course",
            description = "Let delete a Course"
    )
    @DeleteMapping(value = "/{id}")
    public CustomResponse<Boolean> delete(@PathVariable(value = "id") @Parameter(description = "Course id") Long id) {
        service.delete(id);
        return CustomResponse.of(true);
    }
}
