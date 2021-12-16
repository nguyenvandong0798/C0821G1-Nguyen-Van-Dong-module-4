package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Sandwich {
    @GetMapping ("/")
    public String show (){
        return "index";
    }

    @PostMapping ("/save")
    public String save(@RequestParam(name = "name") String[] condiment, Model model){
        model.addAttribute("condiment", condiment);
        return "search";
    }
}
