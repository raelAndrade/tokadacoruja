package br.com.tokadacoruja.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.com.tokadacoruja.services.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/login").permitAll() // A Url /login pode ser acessado por todo mundo, autenticado ou não
			.antMatchers("/cadastro").permitAll() // A Url /registration para a criação de usuários, o usuário pode ser acessar-la autenticado ou não
			.anyRequest() // Agora o restante
				.authenticated() // O usuário deve estar autenticado
					.and().csrf().disable() // Desabilitar o CSRF
				.formLogin() // Onde o usuário vai fazer o login
					.loginPage("/login").failureUrl("/login?error=true").defaultSuccessUrl("/index")
					.usernameParameter("user_name").passwordParameter("password")
				.and().logout()
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web
			.ignoring()
			.antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/img/**", "/fonts/**");
	}
	
	
	
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/login").permitAll()
			.antMatchers("/cadastro").permitAll()
			.antMatchers("/home/**").hasAuthority("ADMIN")
			.antMatchers("/registration/**").hasAuthority("ADMIN")
			.antMatchers("/schedule/**").hasAuthority("ADMIN")
			.anyRequest()
				.authenticated()
				.and()
				.formLogin()
					.loginPage("/login").failureUrl("/login?error=true").defaultSuccessUrl("/index")
					.usernameParameter("user_name").passwordParameter("password")
				.and()
				.logout()
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
				.and()
				.exceptionHandling()
					.accessDeniedPage("/access-denied");
	}*/
}

