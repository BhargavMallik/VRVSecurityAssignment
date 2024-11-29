package com.spring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class JLCSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("srinivas").password("{noop}srinivas").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("vas").password("{noop}vas").roles("STOREKEEPER");
		auth.inMemoryAuthentication().withUser("sd").password("{noop}sd").roles("CUSTOMER");
		auth.inMemoryAuthentication().withUser("ds").password("{noop}ds").roles("CUSTOMER");
		auth.inMemoryAuthentication().withUser("sri").password("{noop}sri").roles("CUSTOMER", "ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/deleteBook**").access("hasRole('ROLE_ADMIN')").antMatchers("/addBook**")
				.access("hasAnyRole('ROLE_ADMIN','ROLE_STOREKEEPER')").antMatchers("/editBook**")
				.access("hasAnyRole('ROLE_ADMIN','ROLE_STOREKEEPER')").antMatchers("/placeOrder**")
				.access("hasAnyRole('ROLE_CUSTOMER')").and().formLogin().loginPage("/login").failureUrl("/login?error")
				.usernameParameter("myusername").passwordParameter("mypassword").and().logout()
				.invalidateHttpSession(true).logoutSuccessUrl("/login?logout").and().exceptionHandling()
				.accessDeniedPage("/WEB-INF/myjsps/invalidAccess.jsp");
	}
}