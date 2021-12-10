package ua.edu.ukma.schedule.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ua.edu.ukma.schedule.model.Permissions;
import ua.edu.ukma.schedule.services.impl.UserServiceImpl;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static ua.edu.ukma.schedule.model.Permissions.PermissionName.*;
import static ua.edu.ukma.schedule.util.ConstantsUtil.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServiceImpl userService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/resources/**", "/h2-console/**", "/css/**", "/").permitAll()
                .antMatchers(GET, FACULTY_API, LESSON_API, COURSE_API, STAFF_API, STUDENT_API).permitAll()
                .antMatchers(POST, FACULTY_API, LESSON_API, STAFF_API, STUDENT_API).hasAnyAuthority(ADMIN.name(), METHODIST.name())
                .antMatchers("/addCourse", "/addCourse-processing", "/addStaff", "/addStaff-processing")
                .hasAuthority(ADMIN.name())
                .antMatchers(POST, "/api/lesson/*/*")
                .hasAuthority(STUDENT.name())
                .antMatchers("/signup", "/signup-processing").anonymous()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .failureForwardUrl("/login-processing")
                .loginProcessingUrl("/login-processing")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login");

        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
    }
}