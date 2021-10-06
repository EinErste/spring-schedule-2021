package schedule.services;

import lombok.SneakyThrows;
import schedule.entities.CourseEntity;

public interface CourseService {

    @SneakyThrows
    CourseEntity getCourse(long id);
}
