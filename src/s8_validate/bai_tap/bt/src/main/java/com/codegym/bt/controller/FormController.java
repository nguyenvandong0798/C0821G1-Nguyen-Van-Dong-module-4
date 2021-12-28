package com.codegym.bt.controller;

import com.codegym.bt.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class FormController {
    @GetMapping ("/form")
    public String showForm(Model model){
        model.addAttribute("user", new User());
        return "/index";
    }
    @PostMapping("create")
    public String showResult(@Valid @ModelAttribute("user") User user,
        BindingResult bindingResult, Model model) {
        new User().validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/form";
        }
        return "/result";
    }
}
