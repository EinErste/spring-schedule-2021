package ua.edu.ukma.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@SpringBootApplication
public class ScheduleApplication {


    public static void main(String[] args) {
        SpringApplication.run(ScheduleApplication.class, args);
    }

}
