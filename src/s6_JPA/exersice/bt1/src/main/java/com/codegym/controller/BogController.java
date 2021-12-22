package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("blog")
public class BogController {
    @Autowired
    @Qualifier("blogService")
    private IBlogService iBlogService;

    @GetMapping(value = {"list", ""})
    public ModelAndView listPage(){
        return new ModelAndView
                ("blog/list_blog","blogs", iBlogService.getAll());
    }

    @GetMapping(value = "detail/{id}")
    public String getBlog(@PathVariable(name = "id") Integer id, Model model){
        Blog blog = iBlogService.findById(id);
        return "blog/detail_blog";
    }
//    @GetMapping(value = {"/list", ""})
//    public ModelAndView listPage(@RequestParam(value = "name", defaultValue = "") String name){
//        return new ModelAndView("blog/list_blog","blogs", iBlogService.findByName(name));
//    }
}
