package ua.kma.spring.schedule.schedule.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kma.spring.schedule.schedule.repositories.LessonRepository;

@Service
public class LessonServiceImpl {
    private final LessonRepository repository;

    @Autowired
    public LessonServiceImpl(LessonRepository repository) {
        this.repository = repository;
    }
}
