package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("blog")
public class BogController {
    @Autowired
    @Qualifier("blogService")
    private IBlogService iBlogService;

    @GetMapping(value = {"list"})
    public ModelAndView listPage(){
        return new ModelAndView
                ("blog/list_blog","blogs", iBlogService.getAll());
    }

    @GetMapping(value = "detail")
    public String getBlogDetailRequestParam(@RequestParam(name = "id") Integer id,
                                               Model model) {
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog", blog);
        return "blog/detail_blog";
    }

    @GetMapping(value = "create")
    public String getPageCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "blog/create_blog";
    }

    @PostMapping(value = "create")
    public String createBlog(@ModelAttribute("blog")Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("msg", "Create blog successfully!");
        return "redirect:/blog/list";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Integer id,RedirectAttributes redirectAttributes){
        iBlogService.remove(id);
        List<Blog> blogs =iBlogService.findAll();
        redirectAttributes.addFlashAttribute("blog",blogs);
        return "redirect:/blog/list";
    }

    @GetMapping(value = "/edit/{id}")
    public String getEditPage(@PathVariable Integer id,Model model){
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog",blog);
        return "/blog/edit_blog";
    }

    @PostMapping(value = "/edit")
    public String edit(@ModelAttribute(value = "blog") Blog blog,RedirectAttributes redirectAttributes){
        iBlogService.save(blog);
//        List<Blog> blogs =iBlogService.findAll();
//        redirectAttributes.addFlashAttribute("blog",blogs);
        return "redirect:/blog/list";
    }
}
