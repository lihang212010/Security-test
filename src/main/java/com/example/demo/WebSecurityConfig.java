package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

@Bean
UserDetailsService customUserService() {
	return new CustomUserSerivce();
}
@Bean
public static NoOpPasswordEncoder passwordEncoder() {
    return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
}
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception{
	auth.userDetailsService(customUserService());
	
}
	@Override
protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().anyRequest().authenticated()
		          .and()
		          .formLogin()
		          .loginPage("/login")
		          .failureUrl("/login?error")
		          .permitAll()
		          .and()
		          
		          .logout().permitAll();
	}
}
