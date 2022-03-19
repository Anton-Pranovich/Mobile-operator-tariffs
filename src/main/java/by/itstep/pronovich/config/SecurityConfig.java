package by.itstep.pronovich.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	AuthenticationSuccessHandler successHandler;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("user")
			.password("{noop}password")
			.roles("USER")
			.and()
			.withUser("admin")
			.password("{noop}password")
			.roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Cross-site reference
		http 
			.authorizeRequests()
			.antMatchers("/**").hasRole("USER")
			.antMatchers("/admin/**").hasRole("ADMIN")
			.and().logout().logoutUrl("/logout").logoutSuccessUrl("/logIn")
			.and()
			.formLogin()
			//.defaultSuccessUrl("/adminStart")
			.loginPage("/logIn")
			.successHandler(successHandler).permitAll();
	}
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**");
	}
}