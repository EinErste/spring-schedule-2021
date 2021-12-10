package ua.edu.ukma.schedule.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

@Table(name = "course")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @SequenceGenerator(name = "id_generator", sequenceName = "id_seq", initialValue = 2, allocationSize = 1)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "course_year")
    private int year;

    @Column(name = "hours")
    private int hours;

    @Column(name = "credits")
    private int credits;

    @Column(name = "max_groups")
    private int maxGroups;

    @Column(name = "season")
    @Enumerated(EnumType.STRING)
    private Season season;

    @OneToMany(mappedBy = "course")
    @Builder.Default
    private Set<Lesson> lessons = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "speciality_course_type")
    @MapKeyColumn(name = "speciality_id")
    @Column(name = "type")
    @Builder.Default
    //Add PROFESSIONAL and NORMATIVE. If course_id is not present, assume type FREE
    private Map<Long, CourseType> typeBySpeciality = new HashMap<>();

    public void resolveRecursion(){
        for (Lesson lesson: lessons) {
            lesson.setCourse(null);
        }
    }
}
