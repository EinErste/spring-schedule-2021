package ua.edu.ukma.schedule.services.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.edu.ukma.schedule.model.Lesson;
import ua.edu.ukma.schedule.repositories.LessonRepository;
import ua.edu.ukma.schedule.services.LessonService;

import java.time.DayOfWeek;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class LessonServiceImpl extends AbstractCRUDService<Lesson> implements LessonService {

    public LessonServiceImpl(JpaRepository<Lesson, Long> repository) {
        super(repository);
    }

    @Override
    public List<Lesson> getAllSortedByTime() {
        return getRepository().findAllByOrderByTimeAsc();
    }

    @Override
    public List<Lesson> getLessonsForWeekDay(List<Lesson> lessons, DayOfWeek dayOfWeek) {
        return lessons.stream().filter(e -> e.getTime().getDayOfWeek().equals(dayOfWeek)).collect(toList());
    }

    private LessonRepository getRepository() {
        return (LessonRepository) repository;
    }
}
