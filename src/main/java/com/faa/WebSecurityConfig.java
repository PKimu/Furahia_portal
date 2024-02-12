package com.faa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig{

	private final UserDetailsServiceImpl userService;
	
	public WebSecurityConfig(UserDetailsServiceImpl userService) {
		this.userService = userService;
	}
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	@Bean
	 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    	
	    			http.authorizeHttpRequests(req->req
	    					.requestMatchers("/").permitAll()
	    					.requestMatchers("/admin").hasAuthority("admin")
	    					.requestMatchers("/editor").hasAnyAuthority("admin","editor")
	    					.requestMatchers("/user").hasAnyAuthority("admin","editor","user")
	    					.anyRequest().authenticated())
	    			.formLogin(login -> login.loginPage("/login")
	    					.usernameParameter("username")
	    					.defaultSuccessUrl("/dashboard", true)
	    					.permitAll())
	    			.logout(logout -> logout.logoutUrl("/logout").permitAll());
	    			
	    			
	    			return http.build();
	    		   
	    }
	
	 
}
