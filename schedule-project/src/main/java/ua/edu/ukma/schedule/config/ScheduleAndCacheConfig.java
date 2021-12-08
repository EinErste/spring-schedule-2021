package ua.edu.ukma.schedule.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import ua.edu.ukma.schedule.cacheManager.MyCacheManager;
import ua.edu.ukma.schedule.services.impl.UserServiceImpl;

import java.util.Arrays;
import java.util.Date;

@Configuration
@EnableScheduling
@EnableCaching
public class ScheduleAndCacheConfig {
    @Autowired
    private UserServiceImpl userService;

    @Scheduled(fixedRate = 10000)
    public void schedulePrintUsersCount() {
        System.out.println("Users count on "+new Date().toString() +" = " +userService.count());
    }

    @Scheduled(cron = "0 * * * * *") //second, minute, hour, day of month, month, day(s) of week
    @CacheEvict(value="username", allEntries = true)
    public void scheduleUsingCron() {
        System.out.println("Username cache removed");
    }

    @Scheduled(fixedRate = 10000)
    public void schedulePrintUsersCount2() {
        System.out.println("Logined users: "+cacheManager().getCache("username").getNativeCache().toString());
    }

    @Bean
    public CacheManager cacheManager() {
        // configure and return an implementation of Spring's CacheManager SPI
        MyCacheManager cacheManager = new MyCacheManager();
        cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("username")));
        return cacheManager;
    }
}
