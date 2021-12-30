package com.codegym.bt.controller;

import com.codegym.bt.dto.UserDTO;
import com.codegym.bt.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class FormController {
    @GetMapping ("/form")
    public String showForm(Model model){
        model.addAttribute("user", new UserDTO());
        return "/index";
    }
    @PostMapping("create")
    public String showResult(@Valid @ModelAttribute("user") UserDTO user,
        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/form";
        }
        return "/result";
    }
}
