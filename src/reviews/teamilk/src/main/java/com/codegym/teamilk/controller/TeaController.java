package com.codegym.teamilk.controller;

import com.codegym.teamilk.model.Tea;
import com.codegym.teamilk.service.ICategoryService;
import com.codegym.teamilk.service.ITeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("tea")
public class TeaController {
    @Autowired
    @Qualifier("teaService")
    private ITeaService iTeaService;

    @Autowired
    @Qualifier("categoryService")
    private ICategoryService iCategoryService;

    @GetMapping(value = "list")
    public ModelAndView listPage(){
        return new ModelAndView("tea/list","tea", iTeaService.getAll());
    }

    @GetMapping(value = "detail")
    public String detail(@RequestParam(name="id") Integer id, Model model){
        Tea teaMilk = iTeaService.findById(id);
        model.addAttribute("tea",teaMilk);
        return "tea/detail";
    }
    @GetMapping(value = "create")
    public String showCreate(Model model){
        model.addAttribute("tea", new Tea());
        model.addAttribute("category", iCategoryService.getAll());
        return "tea/create";
    }
    @PostMapping(value = "create")
    public String create(@ModelAttribute("tea") Tea tea, RedirectAttributes redirectAttributes){
        iTeaService.save(tea);;
        redirectAttributes.addFlashAttribute("msg", "Create tea successfully!");
        return "redirect:/tea/list";
    }
}
