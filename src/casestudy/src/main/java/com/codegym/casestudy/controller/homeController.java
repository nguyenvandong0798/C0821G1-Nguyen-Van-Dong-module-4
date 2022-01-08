package com.codegym.casestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class homeController {
    @GetMapping(value = "home")
    public ModelAndView home(){
        return new ModelAndView("index");
    }
}
