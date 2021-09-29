package ua.kma.spring.schedule.schedule.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.kma.spring.schedule.schedule.enums.LessonType;
import ua.kma.spring.schedule.schedule.enums.Season;

import javax.persistence.*;

@Table(name = "course")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseSpecialityEntity {

    @EmbeddedId
    private ID id;

    @Column(name = "type")
    private LessonType type;

    @Data
    @AllArgsConstructor
    @Builder
    @Embeddable
    public static class ID{
        private static final long serialVersionUID = 1L;
        private long courseID;
        private long specialityID;
    }
}
