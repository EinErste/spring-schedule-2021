package ua.kma.spring.schedule.schedule.services;

import lombok.SneakyThrows;
import ua.kma.spring.schedule.schedule.entities.CourseEntity;

public interface CourseService {

    @SneakyThrows
    CourseEntity getCourse(long id);
}
