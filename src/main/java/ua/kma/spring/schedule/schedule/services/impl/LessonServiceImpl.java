package ua.kma.spring.schedule.schedule.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.kma.spring.schedule.schedule.repositories.LessonRepository;
import ua.kma.spring.schedule.schedule.repositories.UserRepository;

public class LessonServiceImpl {
    private final LessonRepository repository;

    @Autowired
    public LessonServiceImpl(LessonRepository repository) {
        this.repository = repository;
    }
}
