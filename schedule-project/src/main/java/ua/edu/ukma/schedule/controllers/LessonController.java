package ua.edu.ukma.schedule.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import ua.edu.ukma.schedule.model.Lesson;
import ua.edu.ukma.schedule.services.LessonService;
import ua.edu.ukma.schedule.services.StudentService;
import ua.edu.ukma.schedule.util.CustomResponse;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/lesson")
@RequiredArgsConstructor
@Log4j2
@Tag(name = "LessonController", description = "Processing operations with lessons")
public class LessonController {

    private final LessonService service;
    private final StudentService studentService;

    @Operation(summary = "Adding a lesson to student", description = "Let add a lesson to student`s personal schedule")
    @PostMapping(value = "/{studentId}/{lessonId}")
    public void addLessonToUser(@PathVariable @Parameter(description = "Student id") int studentId, @PathVariable @Parameter(description = "Lesson id") int lessonId) {
        studentService.addLesson(studentId, lessonId);
    }

    @Operation(summary = "Create a lesson", description = "Creates a lesson from a given body")
    @PostMapping(value = "")
    public CustomResponse<Long> create(@RequestBody @Valid Lesson lesson) {
        return CustomResponse.of(service.save(lesson).getId());
    }

    @Operation(summary = "Get a lesson", description = "Get a lesson with given id")
    @GetMapping(value = "/{id}")
    public CustomResponse<Lesson> read(@PathVariable(value = "id") @Parameter(description = "Lesson id") Long id) {
        Lesson lesson = service.getById(id);
        lesson.resolveRecursion();
        return CustomResponse.of(lesson);
    }

    @Operation(summary = "Update a lesson", description = "Lets you update a lesson")
    @PutMapping(value = "")
    public CustomResponse<Boolean> update(@RequestBody @Valid Lesson lesson) {
        service.save(lesson);
        return CustomResponse.of(true);
    }

    @Operation(summary = "Delete a lessons", description = "Lets you delete a lesson")
    @DeleteMapping(value = "/{id}")
    public CustomResponse<Boolean> delete(@PathVariable(value = "id") @Parameter(description = "Lesson id") Long id) {
        service.delete(id);
        return CustomResponse.of(true);
    }

}
