package com.codegym.controller;


import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService iproductService;


    @GetMapping("")
    public String showList(Model model){
        List<Product> productList = iproductService.findAll();
        model.addAttribute("products",productList);
        return "index";
    }

    @GetMapping("/{id}/delete")
    public  String showDelete(@PathVariable(name = "id") int id, Model model){
        // @PathVariable(name = "id" lấy ì tư thanh url product/{id}/delete bỏ vào biến int id
        model.addAttribute("product",iproductService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public  String delete(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes){
        iproductService.remove(product.getId());
        redirectAttributes.addFlashAttribute("message","Removed product successfully!");
        return "redirect:/product";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        // tạo thành đối tượng product trong file html create dòng 19
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message","Create success");
        iproductService.save(product);
        return "redirect:/product";
    }


    @GetMapping("{id}/edit")
    public String showEdit(@PathVariable(name = "id") int id, Model model){
        model.addAttribute("product",iproductService.findById(id));
        return "edit";
    }

    @GetMapping("/edit_param")
    public String showEditParam(@RequestParam(name = "id") int id, Model model){
        model.addAttribute("product",iproductService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("product") Product product, Model model,RedirectAttributes redirectAttributes){
        iproductService.update(product.getId(),product);
        redirectAttributes.addFlashAttribute("message","Edit success");
        return "redirect:/product";
    }

    @GetMapping("{id}/view")
    public String view(@PathVariable(name = "id") int id,Model model){
        Product product = iproductService.findById(id);
        model.addAttribute("product",product);
        return "view";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "search") String search, Model model){
        List<Product> productList = iproductService.searchName(search);
        model.addAttribute("productList",productList);
        return "index";
    }
}