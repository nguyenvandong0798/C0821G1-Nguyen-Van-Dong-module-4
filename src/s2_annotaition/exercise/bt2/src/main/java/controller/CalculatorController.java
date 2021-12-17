package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/")
    public String show() {
        return "index";
    }

    @PostMapping("/calculator")
    public String calculator(@RequestParam(name = "number1") int number1,
                             @RequestParam(name = "number2") int number2,
                             @RequestParam(name = "calculated") String calculated, Model model) {
        int result = 0;
        switch (calculated) {
            default:
              break;
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                result = number1 / number2;
                break;
        }
        model.addAttribute("result", result);
        return "result";
    }
}
