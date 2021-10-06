package schedule.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import schedule.repositories.StaffRepository;
import schedule.services.StaffService;

@Service
public class StaffServiceImpl implements StaffService {
    private final StaffRepository repository;

    @Autowired
    public StaffServiceImpl(StaffRepository repository) {
        this.repository = repository;
    }
}
