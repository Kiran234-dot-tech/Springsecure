package com.springsecur.springsecur.Controllers;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurController {
    @RequestMapping("/")
    public String greet(HttpServletRequest request){
        return "Hello Spring Boot"+"  "+request.getSession().getId();
    }
}
