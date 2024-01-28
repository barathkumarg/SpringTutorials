package com.learn.SpringBootApplication.Configuration;


import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {

        UserDetails UserDetail_1 = createnewUser("barath","todo@123");
        UserDetails UserDetail_2 = createnewUser("user","todo@123");
        return new InMemoryUserDetailsManager(UserDetail_1,UserDetail_2);

    }

    //Function for creating the user
    private UserDetails createnewUser(String Username,String Password){
        // password encoder function
        Function<String, String> passwordEncoder
                = input -> passwordEncoder().encode(input);

        // user details constructor
        UserDetails userDetails = User.builder()
                .passwordEncoder(passwordEncoder)
                .username(Username)
                .password(Password)
                .roles("USER","ADMIN")
                .build();
        return userDetails;
    }


    // password encoder function
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    //Allowing the h2 console access with the spring security layer
    //All URLs are protected
    //A login form is shown for unauthorized requests
    //CSRF disable
    //Frames

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated());
        http.formLogin(withDefaults());

        http.csrf().disable();
        http.headers().frameOptions().disable();

        return http.build();
    }


}
