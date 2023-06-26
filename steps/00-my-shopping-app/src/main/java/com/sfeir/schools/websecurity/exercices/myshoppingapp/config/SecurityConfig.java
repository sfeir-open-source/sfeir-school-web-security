package com.sfeir.schools.websecurity.exercices.myshoppingapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.XorCsrfTokenRequestAttributeHandler;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig implements WebMvcConfigurer {
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    var csrfReqAttrHandler = new XorCsrfTokenRequestAttributeHandler();
    csrfReqAttrHandler.setCsrfRequestAttributeName("_csrf");
    http
      .authorizeHttpRequests(requests -> requests
        .anyRequest().authenticated()
      )
      .cors(Customizer.withDefaults())
      .formLogin(form -> form.successForwardUrl("/home")).httpBasic(Customizer.withDefaults())
      .csrf(AbstractHttpConfigurer::disable);
    return http.build();
  }

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**");
  }
}
