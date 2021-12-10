package ua.edu.ukma.schedule.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.edu.ukma.schedule.model.Faculty;
import ua.edu.ukma.schedule.services.FacultyService;

@Service
public class FacultyServiceImpl extends AbstractCRUDService<Faculty> implements FacultyService {

    @Autowired
    public FacultyServiceImpl(JpaRepository<Faculty, Long> repository) {
        this.repository = repository;
    }

}