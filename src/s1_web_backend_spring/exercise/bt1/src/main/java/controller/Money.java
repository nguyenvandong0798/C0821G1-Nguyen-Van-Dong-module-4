package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class Money {
    @GetMapping("")
        public String show( Model model){
            return"index";
        }
    @PostMapping("/money")
    public String money(@RequestParam double usd, Model model) {
    double result = usd * 22000;
    model.addAttribute("result", result);
    model.addAttribute("usd", usd);
        return "index";
    }
}
