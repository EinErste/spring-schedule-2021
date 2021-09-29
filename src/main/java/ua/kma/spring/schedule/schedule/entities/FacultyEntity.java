package ua.kma.spring.schedule.schedule.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.*;

@Table(name = "faculty")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FacultyEntity {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "faculty")
    @Builder.Default
    Set<SpecialityEntity> specialities = new HashSet<>();
}
