package com.codextrees.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.codextrees.web.common.UnauthenticatedRequestHandler;
import com.codextrees.web.service.UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig {
	@Autowired
	private UserService userService;
	@Bean
	UnauthenticatedRequestHandler unauthenticatedRequestHandler() {
	    return new UnauthenticatedRequestHandler();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http
		.authorizeRequests(a -> a
				.antMatchers("/", "/error","/accessdenied", "/webjars/**","/css/**","/images/**","/user",
						"/c-lang/**","/api/**","/article/**","/t/**","/articles","/topics",
						"/google3752f5be1fbf25c2.html","/privacy-policy","/contact","/sitemap.xml").permitAll()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()
			)
			.exceptionHandling(e -> e
				.authenticationEntryPoint(unauthenticatedRequestHandler())
				.accessDeniedPage("/html/accessdenied.html")
			)
			
			.oauth2Login()
		    .loginPage("/login")
		    .userInfoEndpoint()
		    .oidcUserService(this.oidcUserService())
		    .and()
		    .defaultSuccessUrl("/")
		    .and().csrf(c -> c
					.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()
							)
					)
					.logout(l -> l
						.logoutSuccessUrl("/").permitAll()
					);
		return http.build();
	}
	
	private OAuth2UserService<OidcUserRequest, OidcUser> oidcUserService() {
		final OidcUserService delegate = new OidcUserService();

		return (userRequest) -> {
			// Delegate to the default implementation for loading a user
			OidcUser oidcUser = delegate.loadUser(userRequest);
			userService.processOAuthPostLogin(oidcUser.getEmail(),oidcUser.getAttribute("name"));
			
			Collection<? extends GrantedAuthority> mappedAuthorities = userService.loadUserByUsername(oidcUser.getEmail()).getAuthorities();

			
			oidcUser = new DefaultOidcUser(mappedAuthorities, oidcUser.getIdToken(), oidcUser.getUserInfo());
			
			return oidcUser;
		};
	}
	
	
	
}