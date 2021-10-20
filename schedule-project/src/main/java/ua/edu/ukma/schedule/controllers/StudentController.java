package ua.edu.ukma.schedule.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.ukma.schedule.services.impl.StudentServiceImpl;

@RestController
@AllArgsConstructor
public class StudentController {
    private final StudentServiceImpl studentService;

    @GetMapping("/{studentId}/{lessonId}")
    public void test(@PathVariable int studentId, @PathVariable int lessonId){
        studentService.addLesson(studentId,lessonId);
    }

}
