package ua.kma.spring.schedule.schedule.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "speciality")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SpecialityEntity {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name="faculty_id", nullable=false)
    private FacultyEntity faculty;
}