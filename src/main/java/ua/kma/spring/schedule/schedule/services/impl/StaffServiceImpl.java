package ua.kma.spring.schedule.schedule.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.kma.spring.schedule.schedule.repositories.StaffRepository;

public class StaffServiceImpl {
    private final StaffRepository repository;

    @Autowired
    public StaffServiceImpl(StaffRepository repository) {
        this.repository = repository;
    }
}
