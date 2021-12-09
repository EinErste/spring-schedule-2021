package ua.edu.ukma.schedule.services;

import ua.edu.ukma.schedule.model.Course;

import java.util.List;

public interface CourseService extends CRUDService<Course>{

    List<Course> containingName(String name);
}
