package ua.edu.ukma.schedule.services.impl;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.ukma.schedule.model.Lesson;
import ua.edu.ukma.schedule.model.Student;
import ua.edu.ukma.schedule.repositories.StudentRepository;
import ua.edu.ukma.schedule.services.LessonService;
import ua.edu.ukma.schedule.services.StudentService;

@Service
@Log4j2
public class StudentServiceImpl extends AbstractCRUDService<Student> implements StudentService {

    private final LessonService lessonService;

    @Autowired
    public StudentServiceImpl(StudentRepository repository, LessonService lessonService) {
        super(repository);
        this.lessonService = lessonService;
    }

    @SneakyThrows
    @Override
    public Student addLesson(long studentId, long lessonId) {

        Student student = repository.getById(studentId);

        Lesson lesson = lessonService.getById(lessonId);
        if (lesson == null) {
            log.error("Lesson with id {} not found", lessonId);
            throw new Exception("Lesson with id" + lessonId + "  not found");
        }
        student.getLessons().add(lesson);
        return repository.save(student);
    }

}
