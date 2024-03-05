package EMS.Event.Management.System;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collection;
import java.util.stream.Stream;

@EnableWebSecurity
@Configuration//collection of object store
public class My_Authentication {
    @Bean
    public PasswordEncoder mycoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager myadmindetails() {
        UserDetails user1 = User.withUsername("Janani")
                .password(mycoder().encode("Janani@123"))
                .roles("Manager")
                .build();
        UserDetails user2 = User.withUsername("Tamil")
                .password(mycoder().encode("Tamil@123"))
                .roles("Admin")
                .build();

//        Collection<UserDetails>  collect= Stream.of(user1,user2).toList();

        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    @Deprecated
    public SecurityFilterChain myconnect(HttpSecurity hps) throws Exception
    {
//        Any request accessed this username and password
//        hps.authorizeHttpRequests()
//                        .anyRequest()
//                                .authenticated();
        hps.authorizeRequests()
                .requestMatchers("/eventmanagement")
                .authenticated();

        hps.cors();
        hps.csrf().disable();//cross site request forgery -a web attack exploits loopholes
        hps.formLogin();
        hps.httpBasic();

        return hps.build();
    }
}
