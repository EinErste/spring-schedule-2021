package ua.edu.ukma.schedule.services.impl;

import org.springframework.stereotype.Service;
import ua.edu.ukma.schedule.model.Course;
import ua.edu.ukma.schedule.repositories.CourseRepository;
import ua.edu.ukma.schedule.services.CourseService;

import java.util.List;

@Service
public class CourseServiceImpl extends AbstractCRUDService<Course> implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository repository) {
        super(repository);
        this.courseRepository = repository;
    }


    @Override
    public List<Course> containingName(String name){
        return courseRepository.findAllByNameContaining(name);
    }

}