package ua.edu.ukma.schedule.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.ukma.schedule.services.impl.StudentServiceImpl;

@RestController
@RequestMapping("/api/lesson")
@RequiredArgsConstructor
@Log4j2
public class LessonController {
    private final StudentServiceImpl studentService;

    @PostMapping(value = "/{studentId}/{lessonId}")
    public void addLessonToUser(@PathVariable int studentId, @PathVariable int lessonId) {
        studentService.addLesson(studentId, lessonId);
    }

}
