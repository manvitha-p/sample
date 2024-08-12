//package com.demo.config;
//
//import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//@ConditionalOnProperty(name = "keycloak.enabled", havingValue = "true")
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	@Bean
//    public KeycloakSpringBootConfigResolver keycloakConfigResolver() {
//        return new KeycloakSpringBootConfigResolver();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//        http.authorizeRequests()
//                .antMatchers("/enrollments").hasRole("faculty")
//                .antMatchers("/enrollments/{course_id}").hasRole("faculty")
//                .antMatchers("/learners").hasRole("faculty")
//                .antMatchers("/learners/{id}").hasRole("faculty")
//                .antMatchers("/learner/add").hasRole("faculty")
//                .anyRequest().permitAll();
//    }
//}



    