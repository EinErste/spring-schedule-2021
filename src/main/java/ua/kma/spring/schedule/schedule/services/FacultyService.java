package ua.kma.spring.schedule.schedule.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ua.kma.spring.schedule.schedule.repositories.FacultyRepository;

@Service
public class FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;
}