package ua.edu.ukma.schedule.services.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.edu.ukma.schedule.model.Staff;
import ua.edu.ukma.schedule.services.StaffService;

@Service
public class StaffServiceImpl extends AbstractCRUDService<Staff> implements StaffService {

    public StaffServiceImpl(JpaRepository<Staff, Long> repository) {
        super(repository);
    }
}
