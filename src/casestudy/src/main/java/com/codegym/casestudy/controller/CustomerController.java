package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.customer.Customer;
import com.codegym.casestudy.service.customer.ICustomerService;
import com.codegym.casestudy.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.print.DocFlavor;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    @Qualifier("customerservice")
    private ICustomerService iCustomerService;

    @Autowired
    @Qualifier("customertypeservice")
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("list-page")
    public String listPage( Model model, @RequestParam(value = "page",defaultValue = "0") Integer page){
        Sort sort = Sort.by("name").descending();
        Page<Customer> customerPage = iCustomerService.finAll(PageRequest.of(page, 3,sort));
        model.addAttribute("customerPage", customerPage);
        return "customer/list-page";
    }

    @GetMapping("detail")
    public String detail(@RequestParam(name = "id") Integer id, Model model){
        Customer customer = iCustomerService.findById(id);
        model.addAttribute("customer", customer);
        return "customer/detail";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes, Model model){
        iCustomerService.remove(id);
        List<Customer> customers = iCustomerService.getAll();
        model.addAttribute("customer", customers);
        return "redirect:/customer/list-page";
    }

    @GetMapping(value = "create")
    public String showCreate(Model model){
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerType", iCustomerTypeService.getAll());
        return "customer/create";
    }

    @PostMapping(value = "create")
    public String create (@Valid @ModelAttribute("customer") Customer customer,
                          BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("customerType", iCustomerTypeService.getAll());
            return "customer/create";
        }
        iCustomerService.save(customer);
        return "redirect:/customer/list-page";
    }

    @GetMapping(value = "/edit/{id}")
    public String showEdit(@PathVariable Integer id, Model model){
        Customer customer = iCustomerService.findById(id);
        model.addAttribute("customer",customer);
        model.addAttribute("customerType", iCustomerTypeService.getAll());
        return "/customer/edit";
    }

    @PostMapping(value = "/edit")
    public String edit(@ModelAttribute(value = "customer") Customer customer, RedirectAttributes redirectAttributes){
        iCustomerService.save(customer);
//        List<Blog> blogs =iBlogService.findAll();
//        redirectAttributes.addFlashAttribute("blog",blogs);
        return "redirect:/customer/list-page";
    }

    @GetMapping(value = "/search")
    public String search (@RequestParam("name") String name, Model model){
        List<Customer> customers= iCustomerService.findByName(name);
        model.addAttribute("customer", customers);
        return "customer/list-page";
    }

}
