package com.codextrees.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.codextrees.web.service.CustomOAuth2UserService;
import com.codextrees.web.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http
		.authorizeRequests(a -> a
				.antMatchers("/", "/error", "/webjars/**").permitAll()
				
				.anyRequest().authenticated()
			)
			.exceptionHandling(e -> e
				.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
			)
			
			.oauth2Login()
		    .loginPage("/login")
		    .userInfoEndpoint()
		        .userService(oauthUserService)
		    .and()
		    .successHandler(new AuthenticationSuccessHandler() {
		 
		        @Override
		        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
		                Authentication authentication) throws IOException, ServletException {
		 

					DefaultOidcUser oauthUser = (DefaultOidcUser) authentication.getPrincipal();
					String email = oauthUser.getAttribute("email");
					userService.processOAuthPostLogin(email);
					response.sendRedirect("/");
		        }
		    }).and().csrf(c -> c
					.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
					)
					.logout(l -> l
						.logoutSuccessUrl("/").permitAll()
					);
		return http.build();
	}
	@Autowired
	private UserService userService;
	@Autowired
	private CustomOAuth2UserService oauthUserService;


}