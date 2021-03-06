package ua.edu.ukma.schedule.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "faculty")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @SequenceGenerator(name = "id_generator", sequenceName = "id_seq_faculty", initialValue = 1, allocationSize = 1)
    private long id;

    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "full_name")
    @NotBlank
    private String fullName;

    @OneToMany(mappedBy = "faculty")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    private Set<Speciality> specialities = new HashSet<>();
}
