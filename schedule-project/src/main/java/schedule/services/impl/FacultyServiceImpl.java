package schedule.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import schedule.repositories.FacultyRepository;
import schedule.services.FacultyService;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository repository;
}