package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {


    // add support for the JDBC... no more hardcoded users:-)
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        // this will tell JDBC authentification with our data source
        return new JdbcUserDetailsManager(dataSource);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configure->
                configure
                        .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN")
        );

        // use HTTP Basic authentification
        http.httpBasic(Customizer.withDefaults());

        // Disable Cross site Request Forgery(CSRF)
        // In General, not Required for the stateless REST APIs that use POST,PUT ,DELETE and/or PATCH
        http.csrf(csrf->csrf.disable());

        return http.build();

    }


      /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails john= User.builder()
                .username("john")
                .password("{noop}fun123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary=User.builder()
                .username("mary")
                .password("{noop}fun123")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails susan=User.builder()
                .username("susan")
                .password("{noop}fun123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();


        return new InMemoryUserDetailsManager(john,mary,susan);
    }


     */


}
