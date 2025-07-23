package com.shlok.CodeLocker.config;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfig {

    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        http.authorizeHttpRequests(auth ->auth.anyRequest().authenticated()).
                httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
