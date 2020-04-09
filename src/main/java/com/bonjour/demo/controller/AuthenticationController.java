package com.bonjour.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
	
	@RequestMapping("/test")
    public String test() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		String authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
		
        return "Hello Azure Active Directory: " + username + ", Authorities: " + authorities;
    }
	
	@RequestMapping("/authorized")
	@PreAuthorize("hasRole('ROLE_USER')")
    public String onlyAuthorizedUsers() {
        return "Hello USER";
    }
}
