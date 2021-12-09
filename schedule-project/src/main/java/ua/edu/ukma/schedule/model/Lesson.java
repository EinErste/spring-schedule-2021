package ua.edu.ukma.schedule.model;


import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

@Table(name = "lesson")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Lesson {

    @Id
    @GeneratedValue
    @JsonProperty(access = READ_ONLY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Course course;

    @ManyToOne
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staff;

    @Column(name = "lesson_group")
    private int group;

    @Column(name = "lesson_type")
    @Enumerated(EnumType.STRING)
    private LessonType type;

    //recurring by week day and time
    @Column(name = "lesson_time")
    private LocalDateTime time;

    @Column(name = "weeks")
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private String weeks;


    public List<Integer> getWeeks() {
        List<Integer> parsedWeeks = new ArrayList<>();
        int val = 0;

        for (String field : this.weeks.split(",")) {
            try {
                val = Integer.parseInt(field);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            parsedWeeks.add(val);
        }

        return parsedWeeks;
    }

    public void setWeeks(List<Integer> weeks) {
        String newWeeks = "";
        for (int i : weeks) {
            newWeeks = newWeeks.concat(String.valueOf(i));
        }
        this.weeks = newWeeks;
    }

    public void resolveRecursion() {
        course.setLessons(null);
    }
}
