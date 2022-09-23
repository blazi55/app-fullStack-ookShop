package com.ookshop.application.security.config;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@EnableWebSecurity
//@AllArgsConstructor
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private UserDetailsService userDetailsService;
//
//    @Bean
//     AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider provider =
//                new DaoAuthenticationProvider();
//        provider.setUserDetailsService(userDetailsService);
//        provider.setPasswordEncoder(new BCryptPasswordEncoder());
//        return provider;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                    .antMatchers("/loginPage")
//                    .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();
//
//    }
//}