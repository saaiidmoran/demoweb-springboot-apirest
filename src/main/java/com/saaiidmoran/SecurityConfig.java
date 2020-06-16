package com.saaiidmoran;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.saaiidmoran.service.UserService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserService userDetailService;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(bcrypt);
	}
	
	
	
	  @Override protected void configure(HttpSecurity http) throws Exception { 
		  //Codigo comentado que funciona en el modo de SpringWeb App
		  /*
		  http 
			  .authorizeRequests() 
			  .antMatchers( "/public/**").permitAll()
			  .antMatchers("/private/**").authenticated() 
			  .anyRequest().authenticated()
			  .and()
			  .formLogin().loginPage("/login").permitAll() 
			  .and().logout().permitAll();
		  */
		  //Codigo para proteger los servicios REST
		  http
		  .csrf()
		  .disable()
		  .authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
		  .anyRequest()
		  .authenticated()
		  .and()
		  .httpBasic(); 
		 
	  }
	 
	
	

}
