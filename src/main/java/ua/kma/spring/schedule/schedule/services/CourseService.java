package ua.kma.spring.schedule.schedule.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ua.kma.spring.schedule.schedule.repositories.CourseRepository;

@Service
public class CourseService {
    private CourseRepository courseRepository;

    @Autowired
    public void setCourseRepository(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }


}