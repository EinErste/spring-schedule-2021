package ua.edu.ukma.schedule.services.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.edu.ukma.schedule.model.Lesson;
import ua.edu.ukma.schedule.repositories.LessonRepository;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LessonServiceImplTest {

    @Mock
    private LessonRepository repository;

    @InjectMocks
    private LessonServiceImpl service;

    @Test
    void getAllSortedByTimeSuccess() {
        Lesson lesson1 = Lesson.builder().id(1).time(LocalDateTime.of(2021, 12, 8, 11, 40, 0)).build();
        Lesson lesson2 = Lesson.builder().id(2).time(LocalDateTime.of(2021, 12, 8, 10, 0, 0)).build();

        List<Lesson> expected = new LinkedList<>(asList(lesson1, lesson2));
        when(repository.findAllByOrderByTimeAsc()).thenReturn(expected);
        List<Lesson> foundLessons = service.getAllSortedByTime();
        assertEquals(2, foundLessons.size());
        assertEquals(1, foundLessons.get(0).getId());
        assertEquals(2, foundLessons.get(1).getId());
    }

}