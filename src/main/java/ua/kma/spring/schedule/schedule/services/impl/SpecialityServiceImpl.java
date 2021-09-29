package ua.kma.spring.schedule.schedule.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.kma.spring.schedule.schedule.repositories.SpecialityRepository;

public class SpecialityServiceImpl {
    private final SpecialityRepository repository;

    @Autowired
    public SpecialityServiceImpl(SpecialityRepository repository) {
        this.repository = repository;
    }
}
