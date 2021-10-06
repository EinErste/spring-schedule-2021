package schedule.config;


import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import schedule.entities.FacultyEntity;
import schedule.services.impl.CourseServiceImpl;

@Configuration
public class TestConfigClass {
    @Bean
    @ConditionalOnProperty(value = "my.test.property", havingValue = "exist", matchIfMissing = true)
    public void printPropertyExist(){
        System.out.println("Conditional on property exists");
    }
    @Bean
    @ConditionalOnProperty(value = "my.test.property", havingValue = "hide")
    public void printPropertyHide(){
        System.out.println("Conditional on property value is hide");
    }

    @Bean
    @ConditionalOnClass(FacultyEntity.class)
    public void classConditional(){
        System.out.println("FacultyEntity is present");
    }

    @Bean
    @ConditionalOnBean(CourseServiceImpl.class)
    void printBean(){
        System.out.println("CourseServiceImpl bean is present");
    }

    @Bean
    @ConditionalOnMissingBean(CourseServiceImpl.class)
    void printNoBean(){
        System.out.println("CourseServiceImpl bean is not present");
    }
}
