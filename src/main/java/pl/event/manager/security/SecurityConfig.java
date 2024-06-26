package pl.event.manager.security;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    /**
     * This bean is used to declare BCryptPasswordEncoder as a PasswordEncoder
     * @return PasswordEncoder
     **/
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * This bean is used to create initial admin account.
     * It is using User builder to build UserDetails object with default data which is saved in UserDetailsManager
     * Password is encoded by BCryptPasswordEncoder.
     * @return InitializingBean
     **/
    @Bean
    public InitializingBean initializingBean(DataSource dataSource) {
        return () -> {
            String password = new BCryptPasswordEncoder().encode("password");
            UserDetails organizer = User
                    .withUsername("admin")
                    .password(password)
                    .roles("USER","ORGANIZER")
                    .build();
            userDetailsManager(dataSource).createUser(organizer);

            password = new BCryptPasswordEncoder().encode("password");
            UserDetails user = User
                    .withUsername("user")
                    .password(password)
                    .roles("USER")
                    .build();
            userDetailsManager(dataSource).createUser(user);
        };
    }
}
