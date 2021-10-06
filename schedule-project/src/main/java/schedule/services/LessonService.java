package schedule.services;

import lombok.SneakyThrows;
import schedule.entities.LessonEntity;

public interface LessonService {
    @SneakyThrows
    LessonEntity getLesson(long id);
}
