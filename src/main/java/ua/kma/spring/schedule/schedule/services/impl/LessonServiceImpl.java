package ua.kma.spring.schedule.schedule.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.kma.spring.schedule.schedule.entities.LessonEntity;
import ua.kma.spring.schedule.schedule.repositories.LessonRepository;
import ua.kma.spring.schedule.schedule.repositories.StudentRepository;
import ua.kma.spring.schedule.schedule.services.LessonService;
import ua.kma.spring.schedule.schedule.services.StudentService;

@Log4j2
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
@Service
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;
    private final StudentService studentService;

    public void addLessonStudent(long studentID, long lessonID){
        studentService.getStudent(studentID).getLessons().add(getLesson(lessonID));
    }

    @SneakyThrows
    @Override
    public LessonEntity getLesson(long id){
        var wrapped = lessonRepository.findById(id);
        if(!wrapped.isPresent()) throw new IllegalAccessException();
        return wrapped.get();
    }
}
