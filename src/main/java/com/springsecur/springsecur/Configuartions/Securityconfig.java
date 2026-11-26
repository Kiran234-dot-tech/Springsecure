package com.springsecur.springsecur.Configuartions;

import com.springsecur.springsecur.Serivce.MyUserDetailsSerivce;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class Securityconfig {


    //working with database and
    //authication provides checks and vaildate the username,password
    //create our own authications providese, customizing it
    @Bean
    public AuthenticationProvider authenticationProvider(MyUserDetailsSerivce myUserDetailsSerivce) {

        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider(myUserDetailsSerivce);

        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http ,AuthenticationProvider authenticationProvider){

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
                .csrf(customizer  -> customizer.disable())//disable the csrf
                    .authenticationProvider(authenticationProvider)
                .authorizeHttpRequests(request -> request.anyRequest().authenticated()) // dont allow the request before quthicatacion //        http.formLogin(Customizer.withDefaults());
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .build();

    }



//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails user1 = User.withDefaultPasswordEncoder().
//                    username("kiran").
//                    password("k@123")
//                .build();
//        UserDetails user2 = User.withDefaultPasswordEncoder().
//                username("pavan").
//                password("p@123")
//                .build();
//        return new InMemoryUserDetailsManager(user1,user2);
//    }
}
