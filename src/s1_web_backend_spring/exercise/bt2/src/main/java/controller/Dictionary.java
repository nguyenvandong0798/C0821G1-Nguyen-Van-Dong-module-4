package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Dictionary {
    @GetMapping("/")
    public String show(Model model){
        return "index";
    }
    @PostMapping("/dictionary")
    public String dictionary(@RequestParam String search,  Model model){
        Map<String,String> map = new HashMap<>();
        map.put("hello", "xin chao");
        map.put("book", "sach");
        map.put("thank", "cam on");
        String result = map.get(search);
        if (result !=null){
            model.addAttribute("search", result);
            return"index";
        }else {
            model.addAttribute("message", "not found");
            return"index";
        }
    }
}
