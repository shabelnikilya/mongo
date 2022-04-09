package mongo.rest.config;

import mongo.rest.repository.AuthoritiesRepository;
import mongo.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final UserRepository userRepository;
    private final AuthoritiesRepository authoritiesRepository;

    @Autowired
    public SecurityConfiguration(UserRepository repository, AuthoritiesRepository authoritiesRepository) {
        this.userRepository = repository;
        this.authoritiesRepository = authoritiesRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/author/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/book/**").hasAuthority("ADMIN")
                .and()
                .formLogin()
                .defaultSuccessUrl("/book/find-all")
                .permitAll()
                .and()
                .logout().logoutSuccessUrl("/book/find-all");
    }
}
