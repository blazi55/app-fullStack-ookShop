package com.ookshop.application.security.config;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsService {

    UserDetails loadUserByUsername(String userEmail, Long id) throws ExceptionEmail;
}
