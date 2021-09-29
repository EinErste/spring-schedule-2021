package ua.kma.spring.schedule.schedule.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.kma.spring.schedule.schedule.repositories.FacultyRepository;

@Component
public class FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;
}