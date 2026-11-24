package com.springsecur.springsecur;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Securityconfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http){

//        Customizer<CsrfConfigurer<HttpSecurity>> csrfcust =  new Customizer<CsrfConfigurer<HttpSecurity>>() {
//            @Override
//            public void customize(CsrfConfigurer<HttpSecurity> customizer) {
//                customizer.disable();
//            }
//        };
//
//        http.csrf(csrfcust);
        //authorzation
//        Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> authCustomizer =
//                new Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry>() {
//                    @Override
//                    public void customize(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry request) {
//                        request.anyRequest().authenticated();
//                    }
//                };
//
//        http.authorizeHttpRequests(authCustomizer);

        //session magenet
//        Customizer<SessionManagementConfigurer<HttpSecurity>> sessioncust = new Customizer<SessionManagementConfigurer<HttpSecurity>>() {
//            @Override
//            public void customize(SessionManagementConfigurer<HttpSecurity> session) {
//                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//            }
//        }
//        http.sessionManagement(sessioncust);


        //chaning version object flows through the requets
            return http
                .csrf(customizer  -> customizer.disable()) //disable the csrf
                .authorizeHttpRequests(request -> request.anyRequest().authenticated()) // dont allow the request before quthicatacion //        http.formLogin(Customizer.withDefaults());
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .build();
    }
}
