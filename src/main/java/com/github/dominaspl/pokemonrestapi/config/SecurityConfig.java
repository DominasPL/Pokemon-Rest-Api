package com.github.dominaspl.pokemonrestapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder.encode("adminPass")).roles("ADMIN")
                .and()
                .withUser("user").password(passwordEncoder.encode("userPass")).roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .httpBasic()
            .and()
            .authorizeRequests()
            .antMatchers(HttpMethod.GET, "/api/v1/pokemons/**").hasRole("USER")
            .antMatchers(HttpMethod.POST, "/api/v1/pokemons/**").hasRole("ADMIN")
            .antMatchers(HttpMethod.PUT, "/api/v1/pokemons/**").hasRole("ADMIN")
            .antMatchers(HttpMethod.DELETE, "/api/v1/pokemons/**").hasRole("ADMIN")
            .and()
            .csrf().disable()
            .formLogin().disable();
    }


}
