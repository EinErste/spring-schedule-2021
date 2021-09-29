package ua.kma.spring.schedule.schedule.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kma.spring.schedule.schedule.repositories.FacultyRepository;
import ua.kma.spring.schedule.schedule.services.FacultyService;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository repository;
}