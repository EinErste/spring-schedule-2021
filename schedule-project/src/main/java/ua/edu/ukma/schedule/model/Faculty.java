package ua.edu.ukma.schedule.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "faculty")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Faculty {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "full_name")
    private String fullName;

    @OneToMany(mappedBy = "faculty")
    @Builder.Default
    private Set<Speciality> specialities = new HashSet<>();
}
