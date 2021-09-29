package ua.kma.spring.schedule.schedule.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kma.spring.schedule.schedule.repositories.CourseRepository;
import ua.kma.spring.schedule.schedule.services.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository repository;

    @Autowired
    public void setRepository(CourseRepository repository) {
        this.repository = repository;
    }


}