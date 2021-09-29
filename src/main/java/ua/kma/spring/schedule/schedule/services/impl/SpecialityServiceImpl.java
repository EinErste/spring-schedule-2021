package ua.kma.spring.schedule.schedule.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kma.spring.schedule.schedule.repositories.SpecialityRepository;
import ua.kma.spring.schedule.schedule.services.SpecialityService;

@Service
public class SpecialityServiceImpl implements SpecialityService {
    private final SpecialityRepository repository;

    @Autowired
    public SpecialityServiceImpl(SpecialityRepository repository) {
        this.repository = repository;
    }
}
