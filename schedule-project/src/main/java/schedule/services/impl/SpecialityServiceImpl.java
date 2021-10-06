package schedule.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import schedule.repositories.SpecialityRepository;
import schedule.services.SpecialityService;

@Service
public class SpecialityServiceImpl implements SpecialityService {
    private final SpecialityRepository repository;

    @Autowired
    public SpecialityServiceImpl(SpecialityRepository repository) {
        this.repository = repository;
    }
}
