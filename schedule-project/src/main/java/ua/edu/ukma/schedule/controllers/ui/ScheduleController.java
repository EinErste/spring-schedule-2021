package ua.edu.ukma.schedule.controllers.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.edu.ukma.schedule.model.Course;
import ua.edu.ukma.schedule.model.Lesson;
import ua.edu.ukma.schedule.model.Staff;
import ua.edu.ukma.schedule.services.CourseService;
import ua.edu.ukma.schedule.services.LessonService;
import ua.edu.ukma.schedule.services.StaffService;

import java.time.DayOfWeek;
import java.util.*;

import static java.time.DayOfWeek.*;
import static ua.edu.ukma.schedule.util.ConstantsUtil.*;
import static ua.edu.ukma.schedule.util.ConstantsUtil.REDIRECT_LABEL;

@Controller
public class ScheduleController {

    private final LessonService lessonService;
    private final CourseService courseService;
    private final StaffService staffService;

    @Autowired
    public ScheduleController(LessonService lessonService, CourseService courseService, StaffService staffService) {
        this.lessonService = lessonService;
        this.courseService = courseService;
        this.staffService = staffService;
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

    @GetMapping("/addCourse")
    public String addCourse(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute(ERROR_LABEL, null);
        return ADD_COURSE_LABEL;
    }


    @PostMapping("/addCourse-processing")
    public String addCourse(@ModelAttribute Course course, Model model) {
        model.addAttribute("course", courseService.save(course));
        model.addAttribute(SUCCESS_LABEL, "Course added successfully");
        return REDIRECT_LABEL;
    }

    @GetMapping("/addLesson")
    public String addLesson(Model model) {
        model.addAttribute("lesson", new Lesson());
        model.addAttribute(ERROR_LABEL, null);
        model.addAttribute("courses", courseService.getAll());
        model.addAttribute("allStaff", staffService.getAll());
        return ADD_LESSON_LABEL;
    }


    @PostMapping("/addLesson-processing")
    public String addLesson(@ModelAttribute Lesson lesson, Model model) {
        model.addAttribute("lesson", lessonService.save(lesson));
        model.addAttribute(SUCCESS_LABEL, "Lesson added successfully");
        return REDIRECT_LABEL;
    }


}
