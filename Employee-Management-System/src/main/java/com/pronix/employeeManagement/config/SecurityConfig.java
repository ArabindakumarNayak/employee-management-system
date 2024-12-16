package com.pronix.employeeManagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

    @Bean 
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(c->c.disable());
        	http.httpBasic(Customizer.withDefaults())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/saveEmployee", "/getEmployeeById/**","/getAllEmployee/").permitAll() 
                .anyRequest().authenticated()
            );
//            .formLogin(); // Enables form-based login
        return http.build();
    }
    
    
    
    //this if used for in-memory authorization
    
    @Bean
    public UserDetailsService userDetailsService() {
    	
    	UserDetails user1=User
    			.withDefaultPasswordEncoder()
    			.username("Arabinda")
    			.password("Arabinda@1234")
    			.roles("Dev")
    			.build();
    	
    	UserDetails user2=User
    			.withDefaultPasswordEncoder()
    			.username("Liju")
    			.password("Liju@1234")
    			.roles("Dev")
    			.build();
    	
    	
    	return new InMemoryUserDetailsManager(user1,user2);
    	
    }
    
    
    
}
