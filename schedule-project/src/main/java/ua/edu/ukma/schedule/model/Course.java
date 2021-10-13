package ua.edu.ukma.schedule.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Table(name = "course")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {

    @Id
    @GeneratedValue
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

}
