package com.quanlythuvien.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.quanlythuvien.security.service.CustomAuthenticationFailureHandler;
import com.quanlythuvien.security.service.CustomAuthenticationSuccessHandler;


/**
 *
 * @author lvhuy08t2@gmail.com
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired@Qualifier("customUserDetailsService")
	private UserDetailsService customUserDetailsService;
	
	@Autowired@Qualifier("customAuthenticationSuccessHandler")
	private AuthenticationSuccessHandler customAuthenticationSuccessHandler;
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService);
    }
	@Override
	public void configure(WebSecurity web) throws Exception {
		 web
	      .ignoring()
	         .antMatchers("/resources/**"); // 
	}
	@Bean 
	public AuthenticationManager customAuthenticationManager() throws Exception {
		return authenticationManager();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        .authorizeRequests()
        	.antMatchers("/resources/**", "/tk/dangnhap" ).permitAll()  
            .antMatchers("/**").hasAuthority("USER")
            .and()
        .formLogin()
            .loginPage("/tk/dangnhap")
            .usernameParameter("username")
            .passwordParameter("password")
            .loginProcessingUrl("/tk/dangnhap")
            .failureHandler(new CustomAuthenticationFailureHandler())
            .successHandler(new CustomAuthenticationSuccessHandler())
            .defaultSuccessUrl("/gioithieu")
            .permitAll();
		http.csrf().disable();
		
		http.logout().logoutUrl("/tk/thoat").logoutSuccessUrl("/tk/dangnhap");
	}

}
