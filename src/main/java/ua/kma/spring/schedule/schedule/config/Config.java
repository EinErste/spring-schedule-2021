package ua.kma.spring.schedule.schedule.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.kma.spring.schedule.schedule.repositories.CourseRepository;
import ua.kma.spring.schedule.schedule.repositories.FacultyRepository;
import ua.kma.spring.schedule.schedule.repositories.UserRepository;
@Configuration
public class Config {
    @Bean
    public UserRepository userRepository(){
        return new UserRepository();
    }

    @Bean
    public FacultyRepository facultyRepository(){
        return new FacultyRepository();
    }

    @Bean
    public CourseRepository courseRepository(){
        return new CourseRepository();
    }
}
