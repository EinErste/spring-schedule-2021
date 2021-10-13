package ua.edu.ukma.schedule.services.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.edu.ukma.schedule.model.Lesson;
import ua.edu.ukma.schedule.services.LessonService;

@Service
public class LessonServiceImpl extends AbstractCRUDService<Lesson> implements LessonService {

    public LessonServiceImpl(JpaRepository<Lesson, Long> repository) {
        super(repository);
    }
}
