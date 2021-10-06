package schedule.services;

import lombok.SneakyThrows;
import schedule.entities.StudentEntity;

public interface StudentService {
    @SneakyThrows
    StudentEntity getStudent(long id);
}
