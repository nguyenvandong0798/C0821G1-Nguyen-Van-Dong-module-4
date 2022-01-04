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

import java.util.HashMap;
import java.util.List;

@Controller
public class ShoppingCartController {

    @Autowired
    private IProductService productService;

    @Autowired
    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart (@SessionAttribute("cart") Cart cart){
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }

        @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes){
        productService.remove(id);
        List<Product> products = productService.findAllL();
        redirectAttributes.addFlashAttribute("products",products);
        return "redirect:/shopping-cart";
    }

    @GetMapping("/pay")
    public String payment(@SessionAttribute("cart") Cart cart, Model model){
        model.addAttribute("cart",cart);
        return "pay";
    }

    @PostMapping("/pay")
    public String pay(@SessionAttribute("cart") Cart cart, Model model, RedirectAttributes redirectAttributes){
        cart.setProducts(new HashMap<>());
        return "redirect:/shop";
    }

}
