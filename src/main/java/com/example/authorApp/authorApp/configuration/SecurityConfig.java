package com.example.authorApp.authorApp.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("author")
                .password("$2y$12$PCbzXpnwzUwD/Es4Ju27JusOGg5ep8gYo2psOQVYlUqnv2sObSS52")
                .roles("AUTHOR")
                .and()
                .withUser("admin")
                .password("$2y$12$PCbzXpnwzUwD/Es4Ju27JusOGg5ep8gYo2psOQVYlUqnv2sObSS52")
                .roles("ADMIN")
        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
                .antMatchers( "/admin/**").hasRole("ADMIN")
                .antMatchers("/books/**").hasAnyRole("AUTHOR", "ADMIN")
                .antMatchers("/authors/**").hasAnyRole("AUTHOR", "ADMIN")
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .httpBasic().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);;
    }

}
