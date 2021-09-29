package ua.kma.spring.schedule.schedule.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    private Set<SpecialityEntity> specialities = new HashSet<>();
}
