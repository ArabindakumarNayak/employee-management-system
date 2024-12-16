package com.pronix.employeeManagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

    @Bean 
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(c->c.disable())
        	.httpBasic(Customizer.withDefaults())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/saveEmployee", "/getEmployeeById/**").permitAll() 
                .anyRequest().authenticated()
            )
            .formLogin(); // Enables form-based login
        return http.build();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

//    @Bean
    public AuthenticationManagerBuilder configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("ashok").password("ashok@123").authorities("admin").and()
            .withUser("raju").password("raju@123").authorities("read").and()
            .withUser("mahesh").password("mahesh@123").authorities("read");
        return auth;
    }
    
    
    
}
