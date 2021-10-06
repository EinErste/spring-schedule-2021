package schedule.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import lombok.var;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import schedule.entities.CourseEntity;
import schedule.repositories.CourseRepository;
import schedule.services.CourseService;

@Log4j2
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;


    @SneakyThrows
    @Override
    public CourseEntity getCourse(long id){
        var wrapped = repository.findById(id);
        if(!wrapped.isPresent()) throw new IllegalAccessException();
        return wrapped.get();
    }
}