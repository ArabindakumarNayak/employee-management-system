package com.pronix.employeeManagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(c -> c.disable());
		http.httpBasic(Customizer.withDefaults())
//        	.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(auth -> auth.requestMatchers("/saveEmployee", "/getEmployeeById/**").permitAll()
						.anyRequest().authenticated()

				);
//            .formLogin(); // Enables form-based login
		return http.build();
	}

	// this if used for in-memory authorization

//    @Bean
//    public UserDetailsService userDetailsService() {
//    	
//    	UserDetails user1=User
//    			.withDefaultPasswordEncoder()
//    			.username("Arabinda")
//    			.password("Arabinda@1234")
//    			.roles("Dev")
//    			.build();
//    	
//    	UserDetails user2=User
//    			.withDefaultPasswordEncoder()
//    			.username("Liju")
//    			.password("Liju@1234")
//    			.roles("Dev")
//    			.build();
//    	
//    	
//    	return new InMemoryUserDetailsManager(user1,user2);
//    	
//    }

	// custom authentication using AuthenticationProvider

	@Bean
	public AuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//    	provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		provider.setUserDetailsService(userDetailsService);
		return provider;

	}

}
