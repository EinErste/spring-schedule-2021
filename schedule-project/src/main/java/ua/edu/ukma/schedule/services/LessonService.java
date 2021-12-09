package ua.edu.ukma.schedule.services;

import ua.edu.ukma.schedule.model.Lesson;

import java.time.DayOfWeek;
import java.util.List;

public interface LessonService extends CRUDService<Lesson>{

    List<Lesson> getAllSortedByTime();

    List<Lesson> getLessonsForWeekDay(List<Lesson> lessons, DayOfWeek dayOfWeek);
}
