package com.codegym.bt.controller;

import com.codegym.bt.model.Book;
import com.codegym.bt.service.IBookService;
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
@RequestMapping(name = "book")
public class BookController {
    @Autowired
    @Qualifier("bookService")
    private IBookService iBookService;

    @Autowired
    private ICodeService iCodeService;

    @GetMapping(value = {"list"})
    public ModelAndView listPage(){
        return new ModelAndView
                ("book/list_book","books", iBookService.getAll());
    }

    @GetMapping(value = "detail")
    public String getBlogDetailRequestParam(@RequestParam(name = "id") Integer id,
                                            Model model) {
        Book book = iBookService.findById(id);
        model.addAttribute("books", book);
        return "book/detail_book";
    }

    @GetMapping(value = "create")
    public String getPageCreate(Model model) {
        model.addAttribute("books", new Book());
        model.addAttribute("code", iCodeService.findAll());
        return "book/create_book";
    }

    @PostMapping(value = "create")
    public String createBlog(@ModelAttribute("books")Book book, RedirectAttributes redirectAttributes) {
        iBookService.save(book);
        redirectAttributes.addFlashAttribute("msg", "Create book successfully!");
        return "redirect:/book/list";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        iBookService.remove(id);
        List<Book> books = iBookService.findAll();
        redirectAttributes.addFlashAttribute("books",books);
        return "redirect:/book/list";
    }

    @GetMapping(value = "/edit/{id}")
    public String getEditPage(@PathVariable Integer id, Model model){
        Book book = iBookService.findById(id);
        model.addAttribute("books",book);
        model.addAttribute("codes", iCodeService.findAll());
        return "/book/edit_book";
    }

    @PostMapping(value = "/edit")
    public String edit(@ModelAttribute(value = "books") Book book, RedirectAttributes redirectAttributes){
        iBookService.save(book);
//        List<Blog> blogs =iBlogService.findAll();
//        redirectAttributes.addFlashAttribute("blog",blogs);
        return "redirect:/book/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "name") String name, Model model) {
        List<Book> bookList = iBookService.findByName(name);
        model.addAttribute("books", bookList);
        return "book/search_book";
    }
}
