package com.codegym.c0821g1.controller;

import com.codegym.c0821g1.model.Blog;
import com.codegym.c0821g1.model.Category;
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
@RequestMapping("categories")
public class CategoryController {
    @Autowired
    @Qualifier("categoryService")
    private ICategoryService iCategoryService;


    @GetMapping(value = {"list"})
    public ModelAndView listPage(){
        return new ModelAndView
                ("categories/list_category","categories", iCategoryService.getAll());
    }

    @GetMapping(value = "detail")
    public String getBlogDetailRequestParam(@RequestParam(name = "id") Integer id,
                                            Model model) {
        Category category = iCategoryService.findById(id);
        model.addAttribute("category", category);
        return "categories/detail_category";
    }

    @GetMapping(value = "create")
    public String getPageCreate(Model model) {
        model.addAttribute("category", new Blog());
        model.addAttribute("category", iCategoryService.findAll());
        return "categories/create_category";
    }

    @PostMapping(value = "create")
    public String createBlog(@ModelAttribute("category")Category category, RedirectAttributes redirectAttributes) {
        iCategoryService.save(category);
        redirectAttributes.addFlashAttribute("msg", "Create category successfully!");
        return "redirect:/categories/list";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        iCategoryService.remove(id);
        List<Category> categories = iCategoryService.findAll();
        redirectAttributes.addFlashAttribute("category",categories);
        return "redirect:/categories/list";
    }

    @GetMapping(value = "/edit/{id}")
    public String getEditPage(@PathVariable Integer id, Model model){
        Category category = iCategoryService.findById(id);
        model.addAttribute("blog",category);
        model.addAttribute("category", iCategoryService.findAll());
        return "/categories/edit_category";
    }

    @PostMapping(value = "/edit")
    public String edit(@ModelAttribute(value = "blog") Category category, RedirectAttributes redirectAttributes){
        iCategoryService.save(category);
//        List<Blog> blogs =iBlogService.findAll();
//        redirectAttributes.addFlashAttribute("blog",blogs);
        return "redirect:/categories/list";
    }
    @GetMapping(value = "list-page")
    public String listPageable(Model model, @RequestParam(value = "page", defaultValue = "0")int page) {
        Sort sort = Sort.by("name").descending();
        Page<Category> categoryPage = iCategoryService.findAll(PageRequest.of(page,2,sort));
        model.addAttribute("blogPage", categoryPage);
        return "categories/list_page";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "name") String name, Model model) {
        List<Category> categoryList = iCategoryService.findByName(name);
        model.addAttribute("blogs", categoryList);
        return "categories/search_category";
    }

}
