package ua.edu.ukma.schedule.model.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.edu.ukma.schedule.model.*;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.*;

import static org.springframework.context.i18n.LocaleContextHolder.getLocale;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class WeekSchedule {

    private static final int WEEKS_TOTAL = 16;
    private static final int DAYS_TOTAL = 7;
    
    @Builder.Default
    private WeekSchedule.Week[] weeks = new WeekSchedule.Week[WEEKS_TOTAL];


    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    private static class Week{

        private int number;
        @Builder.Default
        private Day[] days = new WeekSchedule.Day[DAYS_TOTAL];
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

        private String course;

        private String staffName;

        private int group;

        private String type;

        private LocalTime time;
    }


    public static WeekSchedule convert(Set<ua.edu.ukma.schedule.model.Lesson> lessons){
        WeekSchedule weekSchedule = new WeekSchedule();

        for (int i = 0; i < WEEKS_TOTAL; i++) {
            weekSchedule.weeks[i] = Week.builder().number(i+1).build();
            for (int j = 1; j <= DAYS_TOTAL; j++) {
                weekSchedule.weeks[i].days[j-1] = Day.builder().name(DayOfWeek.of(j).name()).build();
            }
        }
        for (ua.edu.ukma.schedule.model.Lesson l: lessons) {
            List<Integer> weekNums = l.getWeeks();
            for (int i = 0; i < WEEKS_TOTAL; i++) {
                if(weekNums.contains(i + 1)){
                    Lesson lesson = Lesson.builder()
                            .course(l.getCourse().getName())
                            .group(l.getGroup())
                            .staffName(l.getStaff().getSurname() + " " + l.getStaff().getName())
                            .type(l.getType().name())
                            .time(l.getTime().toLocalTime())
                            .build();
                    int day = l.getTime().getDayOfWeek().getValue()-1;
                    weekSchedule.weeks[i].days[day].lessons.add(lesson);
                }
            }
        }
        for (int i = 0; i < WEEKS_TOTAL; i++) {
            for (int j = 0; j < DAYS_TOTAL; j++) {
                weekSchedule.weeks[i].days[j].lessons.sort(Comparator.comparing(o -> o.time));
            }
        }
        return weekSchedule;
    }

    public static void main(String[] args) {
        ua.edu.ukma.schedule.model.Lesson lesson = ua.edu.ukma.schedule.model.Lesson.builder()
                .group(3)
                .staff(Staff.builder().name("Name").surname("Surname").build())
                .time(LocalDateTime.now())
                .course(Course.builder().name("Course name").build())
                .type(LessonType.LECTURE)
                .weeks("1,2,3,4,7,9,14")
                .build();
        WeekSchedule schedule = convert(Collections.singleton(lesson));

        for (int i = 0; i < WEEKS_TOTAL; i++) {
            System.out.println(Arrays.toString(schedule.weeks[i].days));
        }
    }
}
