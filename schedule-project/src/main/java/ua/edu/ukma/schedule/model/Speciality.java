package ua.edu.ukma.schedule.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="speciality")
public class Speciality {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @SequenceGenerator(name = "id_generator", sequenceName = "id_seq_speciality", initialValue = 4, allocationSize = 1)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private int code;


    @ManyToOne
    @JoinColumn(name = "faculty_id", nullable = false)
    @JsonBackReference
    private Faculty faculty;
}
