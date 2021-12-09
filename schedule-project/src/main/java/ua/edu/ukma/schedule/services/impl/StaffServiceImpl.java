package ua.edu.ukma.schedule.services.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.edu.ukma.schedule.model.Permissions;
import ua.edu.ukma.schedule.model.Staff;
import ua.edu.ukma.schedule.repositories.PermissionRepository;
import ua.edu.ukma.schedule.services.StaffService;

import static java.util.Collections.singletonList;

@Service
public class StaffServiceImpl extends AbstractCRUDService<Staff> implements StaffService {

    private final PermissionRepository permissionRepository;

    public StaffServiceImpl(JpaRepository<Staff, Long> repository, PermissionRepository permissionsRepository) {
        super(repository);
        this.permissionRepository = permissionsRepository;
    }

    @Override
    public Staff save(Staff user) {
        user.setPermissions(singletonList(permissionRepository.findByPermission(Permissions.PermissionName.METHODIST)));
        return repository.save(user);
    }
}
