package schedule.entities;

import lombok.*;
import schedule.enums.LessonType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "lesson")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LessonEntity {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private CourseEntity course;

    @ManyToOne
    @JoinColumn(name = "staff_id", nullable = false)
    private StaffEntity staff;

    @Column(name = "lesson_group")
    private int group;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private LessonType type;

    //recurring by week day and time
    @Column(name = "time")
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


}
