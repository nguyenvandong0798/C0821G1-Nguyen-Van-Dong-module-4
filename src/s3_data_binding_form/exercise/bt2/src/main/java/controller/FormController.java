package controller;

import model.Form;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {
    @GetMapping("")
    public String create(Model model){
        String [] nation = {"VN", "USA", "CN"};
        String [] gender = {"male", "female"};
        String [] transfer = {"tau bay", "thuyen", "oto"};
        String [] province = {"DN", "HCM", "HN"};
        String [] booleans = {"true", "false"};
        model.addAttribute("nation", nation);
        model.addAttribute("gender", gender);
        model.addAttribute("transfer", transfer);
        model.addAttribute("province", province);
        model.addAttribute("form", new Form());
        return "create";
    }
    @PostMapping("/form")
    public String show(@ModelAttribute("form") Form form, Model model){
        model.addAttribute("form", form);
        return "show";
    }
}
