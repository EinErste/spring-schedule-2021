package ua.edu.ukma.schedule.controllers.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.edu.ukma.schedule.model.Lesson;
import ua.edu.ukma.schedule.services.LessonService;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.time.DayOfWeek.*;

@Controller
public class ScheduleController {

    private final LessonService lessonService;

    @Autowired
    public ScheduleController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("/")
    public String getMainPage(Model model) {
        List<Lesson> lessons = lessonService.getAllSortedByTime();

        Map<DayOfWeek, List<Lesson>> schedule = new TreeMap<>();
        schedule.put(MONDAY, lessonService.getLessonsForWeekDay(lessons, MONDAY));
        schedule.put(TUESDAY, lessonService.getLessonsForWeekDay(lessons, TUESDAY));
        schedule.put(WEDNESDAY, lessonService.getLessonsForWeekDay(lessons, WEDNESDAY));
        schedule.put(THURSDAY, lessonService.getLessonsForWeekDay(lessons, THURSDAY));
        schedule.put(FRIDAY, lessonService.getLessonsForWeekDay(lessons, FRIDAY));

        model.addAttribute("schedule", schedule);
        return "index";
    }

}
