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
//			.antMatchers("/web/users").authenticated()
//			.antMatchers("/web/categories/**")./hasAnyRole("ADMIN")
//			.antMatchers("/web/categories").authenticated()
//			.antMatchers("/web/courses/**").hasAnyRole("ADMIN","TEACHER")
//			.antMatchers("/web/courses").authenticated()
//			.antMatchers("/web/users/signup").permitAll()
//			.antMatchers("/web/users/signin").permitAll()
			.antMatchers("/**").permitAll() // For demonstration
	//		.antMatchers("/","static/css","static/js").permitAll()
			.and()
			.formLogin().permitAll()
			.loginPage("/web/users/signin")
			.loginProcessingUrl("/web/users/signin")
			.defaultSuccessUrl("/web/users/home",true)
			.failureUrl("/web/users/signin").permitAll()
			.and()
			.logout()
			.logoutUrl("/web/users/logout")
			.logoutSuccessUrl("/");
		
	}

}
