package com.codegym.bt.controller;


import com.codegym.bt.model.Code;
import com.codegym.bt.service.ICodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("code")
public class CodeController {
    @Autowired
    @Qualifier("codeService")
    private ICodeService iCodeService;

    @GetMapping(value = "list")
    public ModelAndView listPage(){
        return new ModelAndView
                ("code/list_code","codes", iCodeService.getAll());
    }

    @GetMapping(value = "detail")
    public String getBlogDetailRequestParam(@RequestParam(name = "id") Integer id,
                                            Model model) {
        Code code = iCodeService.findById(id);
        model.addAttribute("codes", code);
        return "code/detail_code";
    }

    @GetMapping(value = "create")
    public String getPageCreate(Model model) {
        model.addAttribute("codes", new Code());
        model.addAttribute("code", iCodeService.findAll());
        return "code/create_code";
    }

    @PostMapping(value = "create")
    public String createBlog(@ModelAttribute("codes")Code code, RedirectAttributes redirectAttributes) {
        iCodeService.save(code);
        redirectAttributes.addFlashAttribute("msg", "Create code successfully!");
        return "redirect:/code/list";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        iCodeService.remove(id);
        List<Code> codeList = iCodeService.findAll();
        redirectAttributes.addFlashAttribute("codes",codeList);
        return "redirect:/book/list";
    }

    @GetMapping(value = "/edit/{id}")
    public String getEditPage(@PathVariable Integer id, Model model){
        Code code = iCodeService.findById(id);
        model.addAttribute("codes",code);
//        model.addAttribute("codes", iCodeService.findAll());
        return "/code/edit_code";
    }

    @PostMapping(value = "/edit")
    public String edit(@ModelAttribute(value = "books") Code code, RedirectAttributes redirectAttributes){
        iCodeService.save(code);
//        List<Blog> blogs =iBlogService.findAll();
//        redirectAttributes.addFlashAttribute("blog",blogs);
        return "redirect:/code/list";
    }
}
