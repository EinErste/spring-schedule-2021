package ua.edu.ukma.schedule.services.impl;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ua.edu.ukma.schedule.model.Lesson;
import ua.edu.ukma.schedule.model.Permissions;
import ua.edu.ukma.schedule.model.Student;
import ua.edu.ukma.schedule.model.User;
import ua.edu.ukma.schedule.repositories.PermissionRepository;
import ua.edu.ukma.schedule.repositories.StudentRepository;
import ua.edu.ukma.schedule.services.LessonService;
import ua.edu.ukma.schedule.services.StudentService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Log4j2
public class StudentServiceImpl extends AbstractCRUDService<Student> implements StudentService {
    private final LessonService lessonService;
    private final PermissionRepository permissionRepository;
    private static final Marker SHOW = MarkerManager.getMarker("SHOW");

    @Autowired
    public StudentServiceImpl(StudentRepository repository, LessonService lessonService, PermissionRepository permissionsRepository) {
        super(repository);
        this.lessonService = lessonService;
        this.permissionRepository = permissionsRepository;
    }

    @SneakyThrows
    @Override
    public Student addLesson(long studentId, long lessonId) {
        ThreadContext.put("currentThread", Thread.currentThread().getName());
        ThreadContext.put("currentUser", SecurityContextHolder.getContext().getAuthentication().getName());
        try {
            Student student = repository.getById(studentId);
            Lesson lesson = lessonService.getById(lessonId);
            student.getLessons().add(lesson);
            log.info(SHOW, "Lesson with id {} was added to student with id {}", lessonId, studentId);
            ThreadContext.clearAll();
            return repository.save(student);
        }catch (EntityNotFoundException e){
            log.error(SHOW,e.getMessage());
            ThreadContext.clearAll();
            //throw e;
        }
        return null;

    }
    @Override
    public Student save(Student user){
        user.setPermissions(List.of(permissionRepository.findByPermission(Permissions.PermissionName.STUDENT)));
        return super.save(user);
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

}
