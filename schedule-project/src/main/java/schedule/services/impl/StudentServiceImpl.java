package schedule.services.impl;

import lombok.SneakyThrows;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import schedule.entities.StudentEntity;
import schedule.repositories.StudentRepository;
import schedule.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;

    @Autowired
    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @SneakyThrows
    @Override
    public StudentEntity getStudent(long id){
        var wrapped = repository.findById(id);
        if(!wrapped.isPresent()) throw new IllegalAccessException();
        return wrapped.get();
    }
}
