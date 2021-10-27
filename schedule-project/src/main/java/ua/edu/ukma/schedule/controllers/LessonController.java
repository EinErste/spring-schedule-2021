package ua.edu.ukma.schedule.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import ua.edu.ukma.schedule.services.impl.StudentServiceImpl;

@RestController
@RequestMapping("/api/lesson")
@RequiredArgsConstructor
@Log4j2
public class LessonController {
    private final StudentServiceImpl studentService;

    @RequestMapping(value = "/{studentId}/{lessonId}", method = RequestMethod.POST)
    public void addLessonToUser(@PathVariable int studentId, @PathVariable int lessonId){
        studentService.addLesson(studentId,lessonId);
    }

}
