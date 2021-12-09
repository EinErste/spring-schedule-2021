package ua.edu.ukma.schedule.model.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.edu.ukma.schedule.model.CourseType;
import ua.edu.ukma.schedule.model.Lesson;
import ua.edu.ukma.schedule.model.Season;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class WeekSchedule {

    @Builder.Default
    private WeekSchedule.Week[] weeks = new WeekSchedule.Week[16];


    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    private static class Week{
        @Builder.Default
        private Day[] days = new WeekSchedule.Day[7];
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    private static class Day{

        private String name;

        @Builder.Default
        private List<WeekSchedule.Lesson> lessons = new ArrayList<>();

    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    private static class Lesson{

        private String staffName;

        private int group;

        private String type;

        private String time;
    }
    public WeekSchedule convert(Set<ua.edu.ukma.schedule.model.Lesson> lessons){
        WeekSchedule weekSchedule = new WeekSchedule();
        for (ua.edu.ukma.schedule.model.Lesson l: lessons) {
            List<Integer> weekNums = l.getWeeks();
            for (int i = 1; i <= 16; i++) {
                if(weekNums.contains(i)){

                }
            }
            Lesson lesson = Lesson.builder()
                    .group(l.getGroup())
                    .staffName(l.getStaff().getSurname() + " " + l.getStaff().getName())
                    .type(l.getType().name())
                    .time(l.getTime().toLocalTime().format(DateTimeFormatter.ISO_TIME))
                    .build();
        }
        return weekSchedule;
    }
}
