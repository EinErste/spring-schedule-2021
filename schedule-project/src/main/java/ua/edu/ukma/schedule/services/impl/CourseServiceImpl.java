package ua.edu.ukma.schedule.services.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.edu.ukma.schedule.model.Course;
import ua.edu.ukma.schedule.services.CourseService;

@Service
public class CourseServiceImpl extends AbstractCRUDService<Course>  implements CourseService {

    public CourseServiceImpl(JpaRepository<Course, Long> repository) {
        super(repository);
    }

}