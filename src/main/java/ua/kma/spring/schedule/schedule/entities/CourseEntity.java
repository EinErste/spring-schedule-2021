package ua.kma.spring.schedule.schedule.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.kma.spring.schedule.schedule.enums.LessonType;
import ua.kma.spring.schedule.schedule.enums.Season;

import javax.persistence.*;
import java.util.*;

@Table(name = "course")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseEntity {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "year")
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
    Set<LessonEntity> lessons = new HashSet<>();

}