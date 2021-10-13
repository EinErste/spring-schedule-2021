package ua.edu.ukma.schedule.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "student")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Student extends User {

    @Column(name = "student_year")
    private int year;

    @ManyToMany
    @JoinTable(
            name = "student_lesson",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "lesson_id"))
    @Builder.Default
    private Set<Lesson> lessons = new HashSet<>();
}
