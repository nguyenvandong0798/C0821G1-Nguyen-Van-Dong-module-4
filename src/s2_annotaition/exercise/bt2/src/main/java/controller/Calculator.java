package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Calculator {
    @GetMapping("/")
    public  String show(){
        return "index";
    }
    @PostMapping("/calculator")
    public String calculator(@RequestParam(name = "number1") int number1,
                            @RequestParam(name = "number2") int number2,
                            @RequestParam(name = "calculated") int calculated , Model model){

        return "result";
    }
}
