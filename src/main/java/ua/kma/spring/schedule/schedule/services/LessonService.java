package ua.kma.spring.schedule.schedule.services;

import lombok.SneakyThrows;
import ua.kma.spring.schedule.schedule.entities.LessonEntity;

public interface LessonService {
    @SneakyThrows
    LessonEntity getLesson(long id);
}
