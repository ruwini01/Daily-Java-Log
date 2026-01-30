package com.ruwini01.Project1.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig {

    private static final String[] PUBLIC_URLS = {
            "/",
            "/login",
            "/register",
            "/css/**",
            "/js/**",
            "/images/**",
            "/webjars/**",
            "/db-console/**"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .authorizeRequests()
                .antMatchers(PUBLIC_URLS).permitAll()
                .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/login")          // GET: your custom login page
                .loginProcessingUrl("/login") // POST: form action
                .defaultSuccessUrl("/", true)
                .failureUrl("/login?error=true")
                .permitAll()
            .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout=true")
                .permitAll();

        // H2 console needs these
        http.csrf()
                .ignoringAntMatchers("/db-console/**");
        http.headers()
                .frameOptions().sameOrigin();

        return http.build();
    }
}
