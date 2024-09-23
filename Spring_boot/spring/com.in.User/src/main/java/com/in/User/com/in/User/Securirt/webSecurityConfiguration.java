package com.in.User.com.in.User.Securirt;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class webSecurityConfiguration {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF protection (not recommended for production)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/signup").permitAll() // Allow public access to /signup
                        .anyRequest().authenticated() // Require authentication for all other requests
                )

//                .exceptionHandling(exception ->
//                        exception.authenticationEntryPoint(new CustomAuthenticationEntryPoint(authenticationEntryPoint)) // Use custom entry point
//                )
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Stateless session management
                );

        return http.build();
//        return security.csrf().disable().authorizeHttpRequests().requestMatchers("/signup").permitAll().and().authorizeHttpRequests().requestMatchers("").authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
