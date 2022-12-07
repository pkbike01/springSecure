package com.springsecure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity

public class MySecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()//authorize the request
		.antMatchers("/home","/login","/register").permitAll()//By the help of AntMatchers we are able to do this things.
		//we can also write in this way .antMatchers("this is pattern"+"/public/**")//it means that we allow all the url which is written something after public
		//it means that we gave the permission to home,long in,register url.
		//(for this we don't need to enter password...)
		.anyRequest()//anyRequest
		.authenticated()//then authenticate the request.
		.and()
		.httpBasic();//mechanism is httpBasic //in basic authentication we cannot logout.
		
	}
	//i want to create my user and password. i don't want to use default user and password.
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("pankaj").password(this.passwordEncoder().encode("pankaj#01")).roles("NORMAL");//Normal --> he will only read the data. He can't do anything with data. 
		auth.inMemoryAuthentication().withUser("susanth").password(this.passwordEncoder().encode("susanth#01")).roles("ADMIN");//Admin -->he will be able to do CURD operation.
		//inMemoryAuthentication()--> it is storing in temporary memory.(it's not permanent.....)
		
	}
	//how to use evaluate in eclipse. 
	
	
	//java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
	//For this we need to create passwordEncoder.
	
	//PasswordEncoder-->Basically, In data Base we don't put password as it is. If we do that then we have a threat to leak the 
	//password.
	//so, To solve this problem we use an object(BCryptPasswordEncoder(10)) of class BCryptPasswordEncoder;
	//BCryptPasswordEncoder-->It helps us to save the password in the form of BCrypt.
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		//  here, i'm not using any password encoder.
//		return NoOpPasswordEncoder.getInstance();//we are using plane text as a password encoder.
//		//this is not use on working level.
//	}
	
	@Bean //I injected @Bean annotation so we can use this in other module means we can perform autowired. 
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
		//BCryptPasswordEncoder("strength is 10.")
	}
	
	
	//AntMatchers-->
	
	
	
	
	
	
}
