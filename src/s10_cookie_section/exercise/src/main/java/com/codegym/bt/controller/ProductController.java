package com.codegym.bt.controller;

import com.codegym.bt.model.Cart;
import com.codegym.bt.model.Product;
import com.codegym.bt.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }


    @GetMapping(value = "/detail")
    public String getBlogDetailRequestParam(@RequestParam(name = "id") Long id,
                                            Model model) {
        Product product = productService.getById(id);
        model.addAttribute("products", product);
//        model.addAttribute("product", productService.findAll());
        return "/detail_product";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("showCre")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        if (action.equals("showDec")) {
            cart.decProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        if (action.equals("list"))
            cart.addProduct(productOptional.get());
        return "redirect:/detail";
    }

}
