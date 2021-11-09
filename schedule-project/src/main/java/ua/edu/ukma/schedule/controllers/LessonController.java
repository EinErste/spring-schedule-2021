package ua.edu.ukma.schedule.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.ukma.schedule.services.StudentService;

@RestController
@RequestMapping("/api/lesson")
@RequiredArgsConstructor
@Log4j2
@Tag(name="LessonController", description="Processing operations with lessons")
public class LessonController {

    private final StudentService studentService;

    @Operation(
            summary = "Adding a lesson to student",
            description = "Let add a lesson to student`s personal schedule"
    )
    @PostMapping(value = "/{studentId}/{lessonId}")
    public void addLessonToUser(@PathVariable @Parameter(description = "Student id")  int studentId, @PathVariable @Parameter(description = "Lesson id")  int lessonId) {
        studentService.addLesson(studentId, lessonId);
    }

}
