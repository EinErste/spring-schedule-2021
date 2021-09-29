package ua.kma.spring.schedule.schedule.services;

import lombok.SneakyThrows;
import ua.kma.spring.schedule.schedule.entities.StudentEntity;

public interface StudentService {
    @SneakyThrows
    StudentEntity getStudent(long id);
}
