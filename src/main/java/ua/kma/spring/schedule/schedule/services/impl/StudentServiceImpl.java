package ua.kma.spring.schedule.schedule.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kma.spring.schedule.schedule.repositories.StudentRepository;

@Service
public class StudentServiceImpl {
    private final StudentRepository repository;

    @Autowired
    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }
}
