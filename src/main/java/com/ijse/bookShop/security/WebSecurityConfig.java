package com.ijse.bookShop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ijse.bookShop.security.jwt.AuthEntryPoint;
import com.ijse.bookShop.security.jwt.AuthTokenFilter;

@Configuration
@EnableMethodSecurity
public class WebSecurityConfig {

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    private AuthEntryPoint unauthorizeHandler;

    @Bean
    public UserDetailsService userDetailsService(){
        return userDetailsServiceImpl;
    }
    
    @Bean
    public AuthTokenFilter authenticationJwTokenFilter(){
        return new AuthTokenFilter();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();           // save paswword hash type
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvder = new DaoAuthenticationProvider();
        authProvder.setUserDetailsService(userDetailsServiceImpl);
        authProvder.setPasswordEncoder(passwordEncoder());
        return authProvder;

    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception{
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.cors().and().csrf(csrf -> csrf.disable())  // Cross-Site Request Forgery (CSRF) 
        .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizeHandler))
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(auth ->
        auth.requestMatchers("/auth/***").permitAll() //login regiseter routs are allowed *** ANY SUB URL IN AUTH                  
        
        .requestMatchers("/admin/***").hasAuthority("ADMIN")
    
    .requestMatchers("/user/***").hasAnyAuthority("ADMIN","USER")
    .anyRequest().authenticated()

    // Hiran
       
        );

        http.authenticationProvider(authenticationProvider());
        http.addFilterBefore(authenticationJwTokenFilter(),UsernamePasswordAuthenticationFilter.class);

        return http.build();


    }

@Bean
    public UserDetailsService users(){
        UserDetails admin = User.builder()
        .username("admin")
        .password("password")
        .roles("ADMIN")
        .build();

        UserDetails user = User.builder()
        .username("user")
        .password("password")
        .roles("USER")
        .build();

       return new InMemoryUserDetailsManager(admin,user);
    }

    
    

}
