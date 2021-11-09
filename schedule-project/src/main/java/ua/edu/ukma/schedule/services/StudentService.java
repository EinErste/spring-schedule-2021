package ua.edu.ukma.schedule.services;

import ua.edu.ukma.schedule.model.Student;

public interface StudentService extends CRUDService<Student> {

    Student addLesson(long studentId, long lessonId);

    boolean existsById(Long id);
}
