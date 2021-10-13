package ua.edu.ukma.schedule.services.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.edu.ukma.schedule.model.Speciality;
import ua.edu.ukma.schedule.services.SpecialityService;

@Service
public class SpecialityServiceImpl extends AbstractCRUDService<Speciality> implements  SpecialityService{

    public SpecialityServiceImpl(JpaRepository<Speciality, Long> repository) {
        super(repository);
    }
}
