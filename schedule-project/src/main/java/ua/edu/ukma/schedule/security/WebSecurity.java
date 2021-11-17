package ua.edu.ukma.schedule.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ua.edu.ukma.schedule.model.Permissions;
import ua.edu.ukma.schedule.repositories.AuthRepository;
import ua.edu.ukma.schedule.services.impl.UserLoginService;

@RequiredArgsConstructor
@Configuration
public class WebSecurity extends WebSecurityConfigurerAdapter {


    private final AuthRepository authRepository;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .authenticationProvider(authProvider())
                .authorizeRequests()
                .antMatchers("api/faculty/*",
                        "api/lesson/*",
                        "api/staff/*",
                        "api/student/*"
                ).hasAuthority(Permissions.PermissionName.ADMIN.name())

                .antMatchers("api/faculty/*",
                        "api/lesson/*",
                        "api/student/*"
                ).hasAuthority(Permissions.PermissionName.METHODIST.name())
                .antMatchers(HttpMethod.GET, "api/staff/*"
                ).hasAuthority(Permissions.PermissionName.METHODIST.name())

                .antMatchers(HttpMethod.GET, "api/faculty/*",
                        "api/lesson/*",
                        "api/staff/*",
                        "api/student/*"
                ).hasAuthority(Permissions.PermissionName.STUDENT.name())
                .antMatchers(HttpMethod.POST,"api/lesson/*/*"
                ).hasAuthority(Permissions.PermissionName.STUDENT.name())

                .antMatchers(
                ).authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll()
                .and()
                .csrf().disable().cors();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new UserLoginService(authRepository);
    }
}