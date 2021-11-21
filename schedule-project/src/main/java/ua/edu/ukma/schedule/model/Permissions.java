package ua.edu.ukma.schedule.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "permissions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Permissions implements GrantedAuthority {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "permission")
    private PermissionName permission;

    @Override
    public String getAuthority() {
        return permission.name();
    }

    public enum PermissionName {
        STUDENT,
        METHODIST,
        ADMIN,
    }
}
