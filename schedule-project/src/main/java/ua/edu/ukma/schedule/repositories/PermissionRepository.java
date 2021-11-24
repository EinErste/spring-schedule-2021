package ua.edu.ukma.schedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.ukma.schedule.model.Permissions;

public interface PermissionRepository extends JpaRepository<Permissions, Integer> {
    Permissions findByPermission(Permissions.PermissionName permissionName);
}
