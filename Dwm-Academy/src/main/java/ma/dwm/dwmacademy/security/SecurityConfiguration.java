package ma.dwm.dwmacademy.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Bean
	public CustomUserDetailsService userDetailsService() {
		return new CustomUserDetailsService();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setPasswordEncoder(passwordEncoder());
		authProvider.setUserDetailsService(userDetailsService());
		return authProvider;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.authorizeRequests()
			.antMatchers("/users").authenticated()
			.antMatchers("/categories/**").hasAnyRole("ADMIN")
			.antMatchers("/categories").authenticated()
			.antMatchers("/courses/**").hasAnyRole("ADMIN","TEACHER")
			.antMatchers("/courses").authenticated()
			.antMatchers("/users/signup").permitAll()
			.antMatchers("/users/signin").permitAll()
	//		.antMatchers("/","static/css","static/js").permitAll()
			.and()
			.formLogin().permitAll()
			.loginPage("/users/signin")
			.loginProcessingUrl("/users/signin")
			.defaultSuccessUrl("/users/home",true)
			.failureUrl("/users/signin").permitAll()
			.and()
			.logout()
			.logoutSuccessUrl("/");
		
	}

}
