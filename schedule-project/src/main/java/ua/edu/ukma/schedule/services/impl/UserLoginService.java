package ua.edu.ukma.schedule.services.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ua.edu.ukma.schedule.model.Permissions;
import ua.edu.ukma.schedule.model.User;
import ua.edu.ukma.schedule.repositories.AuthRepository;


import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
public class UserLoginService implements UserDetailsService {

    private final AuthRepository repo;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final ua.edu.ukma.schedule.model.User user = repo.findUserByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("No user with email: " + username));

        user.getPermissions().forEach(System.out::println);
        return org.springframework.security.core.userdetails.User.builder()
                .username(username)
                .password(user.getPassword())
                .authorities(mapAuthorities(user.getPermissions()))
                .build();
    }

    private static List<GrantedAuthority> mapAuthorities(final List<Permissions> permissions) {
        return permissions.stream()
                .map(Permissions::getPermission)
                .map(Enum::name)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}