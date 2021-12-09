package ua.edu.ukma.schedule.controllers.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.edu.ukma.schedule.model.Lesson;
import ua.edu.ukma.schedule.model.Schedule;
import ua.edu.ukma.schedule.services.LessonService;

import java.time.DayOfWeek;
import java.util.Collection;
import java.util.stream.Collectors;

import static java.time.DayOfWeek.*;
import static java.util.stream.Collectors.toList;

@Controller
public class ScheduleController {

    private final LessonService lessonService;

    @Autowired
    public ScheduleController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("/")
    public String getMainPage(Model model) {
        Collection<Lesson> lessons = lessonService.getAll();
        Schedule schedule = new Schedule();
        schedule.setMonday(lessons.stream().filter(e -> e.getTime().getDayOfWeek().equals(MONDAY)).collect(toList()));
        schedule.setTuesday(lessons.stream().filter(e -> e.getTime().getDayOfWeek().equals(TUESDAY)).collect(toList()));
        schedule.setWednesday(lessons.stream().filter(e -> e.getTime().getDayOfWeek().equals(WEDNESDAY)).collect(toList()));
        schedule.setThursday(lessons.stream().filter(e -> e.getTime().getDayOfWeek().equals(THURSDAY)).collect(toList()));
        schedule.setFriday(lessons.stream().filter(e -> e.getTime().getDayOfWeek().equals(FRIDAY)).collect(toList()));
        model.addAttribute("schedule", schedule);
        model.addAttribute("lessons", lessons);
        return "index";
    }

}
