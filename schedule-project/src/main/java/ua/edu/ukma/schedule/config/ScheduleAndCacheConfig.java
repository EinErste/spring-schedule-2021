package ua.edu.ukma.schedule.config;

import lombok.extern.log4j.Log4j2;
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
@Log4j2
public class ScheduleAndCacheConfig {
    @Autowired
    private UserServiceImpl userService;

    @Scheduled(fixedRate = 10000)
    public void schedulePrintUsersCount() {
        log.debug("Users count on "+new Date().toString() +" = " +userService.count());
    }

    @Scheduled(cron = "0 * * * * *") //second, minute, hour, day of month, month, day(s) of week
    @CacheEvict(value="username", allEntries = true)
    public void scheduleUsingCron() {
        log.debug("Username cache removed");
    }

    @Scheduled(fixedRate = 10000)
    public void schedulePrintUsersCount2() {
        log.debug("Logined users: "+cacheManager().getCache("username").getNativeCache().toString());
    }

    @Bean
    public CacheManager cacheManager() {
        MyCacheManager cacheManager = new MyCacheManager();
        cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("username")));
        return cacheManager;
    }
}
