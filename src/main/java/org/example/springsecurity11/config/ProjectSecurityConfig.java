package org.example.springsecurity11.config;


import org.example.springsecurity11.filter.RequestValidationBeforeFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrfConfig -> csrfConfig.ignoringRequestMatchers("/contact", "/register"))
             //   .addFilterBefore(new RequestValidationBeforeFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests((requests) -> {
                    requests
                            .requestMatchers("/myAccount").hasRole("ADMIN")
                            .requestMatchers("/myBalance").hasAnyRole("ADMIN", "SALES")
                            .requestMatchers("/contact", "/register").permitAll();
                });
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        var obj = http.build();
        return obj;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        var obj = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        //return NoOpPasswordEncoder.getInstance();
        return obj;
    }


}
