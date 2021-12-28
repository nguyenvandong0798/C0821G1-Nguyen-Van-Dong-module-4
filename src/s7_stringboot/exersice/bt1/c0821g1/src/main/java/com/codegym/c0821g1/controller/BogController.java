package com.codegym.c0821g1.controller;

import com.codegym.c0821g1.model.Blog;
import com.codegym.c0821g1.service.IBlogService;
import com.codegym.c0821g1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("blogs")
public class BogController {
    @Autowired
    @Qualifier("blogService")
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping(value = {"list"})
    public ModelAndView listPage(){
        return new ModelAndView
                ("blogs/list_blog","blogs", iBlogService.getAll());
    }

    @GetMapping(value = {"list-category"})
    public ModelAndView listPageCategory(){
        return new ModelAndView
                ("blogs/list_category","blogs", iBlogService.getAll());
    }

    @GetMapping(value = "detail")
    public String getBlogDetailRequestParam(@RequestParam(name = "id") Integer id,
                                               Model model) {
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog", blog);
        return "blogs/detail_blog";
    }

    @GetMapping(value = "create")
    public String getPageCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("category", iCategoryService.findAll());
        return "blogs/create_blog";
    }

    @PostMapping(value = "create")
    public String createBlog(@ModelAttribute("blog")Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("msg", "Create blog successfully!");
        return "redirect:/blogs/list";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        iBlogService.remove(id);
        List<Blog> blogs =iBlogService.findAll();
        redirectAttributes.addFlashAttribute("blog",blogs);
        return "redirect:/blogs/list";
    }

    @GetMapping(value = "/edit/{id}")
    public String getEditPage(@PathVariable Integer id, Model model){
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog",blog);
        model.addAttribute("category", iCategoryService.findAll());
        return "/blogs/edit_blog";
    }

    @PostMapping(value = "/edit")
    public String edit(@ModelAttribute(value = "blog") Blog blog, RedirectAttributes redirectAttributes){
        iBlogService.save(blog);
//        List<Blog> blogs =iBlogService.findAll();
//        redirectAttributes.addFlashAttribute("blog",blogs);
        return "redirect:/blogs/list";
    }
    @GetMapping(value = "list-page")
    public String listPageable(Model model, @RequestParam(value = "page", defaultValue = "0")int page) {
        Sort sort = Sort.by("name").descending();
        Page<Blog> blogPage = iBlogService.findAll(PageRequest.of(page,2,sort));
        model.addAttribute("blogPage", blogPage);
        return "blogs/list_page";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "name") String name, Model model) {
        List<Blog> blogList = iBlogService.findByName(name);
        model.addAttribute("blogs", blogList);
        return "blogs/search_blog";
    }

}
