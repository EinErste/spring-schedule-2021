package ua.edu.ukma.schedule;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import ua.edu.ukma.schedule.annotation.LogExecutionTime;


@RunWith(SpringRunner.class)
class GeneralTest {

    @Test
    @LogExecutionTime
    void test() throws Exception{
        Thread.sleep(1000);
    }
}
