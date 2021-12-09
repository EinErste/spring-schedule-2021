package ua.edu.ukma.schedule.config;


import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.edu.ukma.schedule.model.Faculty;
import ua.edu.ukma.schedule.services.impl.CourseServiceImpl;

@Configuration
@Log4j2
public class TestConfigClass {
    @Bean
    @ConditionalOnProperty(value = "my.test.property", havingValue = "exist", matchIfMissing = true)
    public void printPropertyExist(){
        log.trace("Conditional on property exists");
    }
    @Bean
    @ConditionalOnProperty(value = "my.test.property", havingValue = "hide")
    public void printPropertyHide(){
        log.trace("Conditional on property value is hide");
    }

    @Bean
    @ConditionalOnClass(Faculty.class)
    public void classConditional(){
        log.trace("FacultyEntity is present");
    }

    @Bean
    @ConditionalOnBean(CourseServiceImpl.class)
    void printBean(){
        log.trace("CourseServiceImpl bean is present");
    }

    @Bean
    @ConditionalOnMissingBean(CourseServiceImpl.class)
    void printNoBean(){
        log.trace("CourseServiceImpl bean is not present");
    }
}
