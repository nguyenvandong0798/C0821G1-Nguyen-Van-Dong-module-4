package com.codegym.controller;

import com.codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


public class HelloController {
    @Autowired
    private IStudentService iStudentService;
    //Scope bean

    //@GetMapping -> doGet, value <-> UrlPattern
    @GetMapping(value = "")
    public String helloPage(Model model) {
        model.addAttribute("name", "haiTT");

        //Trang mà bạn muốn hiển thị
        return "hello";
    }

}
