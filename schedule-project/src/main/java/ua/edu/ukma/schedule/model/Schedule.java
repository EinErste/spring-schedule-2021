package ua.edu.ukma.schedule.model;

import lombok.Data;

import java.util.List;

@Data
public class Schedule {

    private List<Lesson> monday;
    private List<Lesson> tuesday;
    private List<Lesson> wednesday;
    private List<Lesson> thursday;
    private List<Lesson> friday;

}
