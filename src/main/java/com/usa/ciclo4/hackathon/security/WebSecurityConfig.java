package com.usa.ciclo4.hackathon.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    // Necesario para evitar que la seguridad se aplique a los resources como los css, imagenes y javascripts
    String[] resources = new String[]
    {
        "/css/**",
        "/icons/**",
        "/img/**",
        "/js/**",
        "/webjars/**",
    };

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
        .antMatchers(resources).permitAll()
        .antMatchers("/","/error","/api/**","/login","/register/**", "/about").permitAll()
        .anyRequest()
        .authenticated()
            .and()
            .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .permitAll()
                .passwordParameter("password")
                .defaultSuccessUrl("/app")
                .failureUrl("/login?error=true")
            .and()
            .logout()
                .permitAll()
            .logoutSuccessUrl("/login?logout").permitAll();
                        
        http.cors().and().csrf().disable();
    }
    
}
