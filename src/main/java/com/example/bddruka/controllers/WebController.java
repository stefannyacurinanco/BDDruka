package com.example.bddruka.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String mostrarLogin() {
        return "login";//Retornando la vista login.html
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String mostrarHello() {
        return "hello";
    }
}
