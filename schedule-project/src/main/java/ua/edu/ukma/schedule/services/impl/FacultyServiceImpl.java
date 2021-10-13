package ua.edu.ukma.schedule.services.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.edu.ukma.schedule.model.Faculty;

@Service
public class FacultyServiceImpl extends AbstractCRUDService<Faculty> {

    public FacultyServiceImpl(JpaRepository<Faculty, Long> repository) {
        super(repository);
    }
}