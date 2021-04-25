package com.example.demo.config;

import com.example.demo.model.RoleEnum;
import com.example.demo.service.implement.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/auth/**").permitAll()
                // API Book
                .antMatchers("/api/books", "/api/books/{id}", "/api/books/all").permitAll()
                .antMatchers("/api/books/action/create", "/api/books/action/update", "/api/books/action/delete/{id}", "/api/books/action/update/{id}").hasAuthority(RoleEnum.ADMIN.toString())
                // API Order
                .antMatchers("/api/orders", "/api/orders/all").permitAll()
                .antMatchers("/api/orders/create").hasAnyAuthority(RoleEnum.ADMIN.toString(), RoleEnum.USER.toString())
                .antMatchers("/api/orders/{id}/change-order-status").hasAuthority(RoleEnum.ADMIN.toString())
                // API Comments
                .antMatchers("/api/comments").permitAll()
                .antMatchers("/api/comments/create", "/api/comments/update", "/api/comments/delete/{id}").hasAnyAuthority(RoleEnum.ADMIN.toString(), RoleEnum.USER.toString())
                // API User
                .antMatchers("/api/users/all", "/api/users/create").permitAll()
                .antMatchers("/api/users/{id}/delete/favoriteBooks", "/api/users/{id}/update/password", "/api/users/{id}/update/add-book-to-favorites").hasAnyAuthority(RoleEnum.ADMIN.toString(),  RoleEnum.USER.toString())
                // API Swagger
                .antMatchers("/v2/api-docs",
                        "/swagger-resources/**",
                        "/configuration/ui",
                        "/configuration/security",
                        "/swagger-ui.html",
                        "/webjars/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(new JwtTokenGeneratorFilter(authenticationManager()))
                .addFilterAfter(new JwtTokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }
}
