package Controller;


import model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller

public class SettingController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showForm(Model model) {
        String [] languages = {"VietNamese","English", "Chinases","Janpanese"};
        String [] pageSizes = {"5", "10", "15"};
        String [] spamFilers = {"Yes", "No"};
        model.addAttribute("languages",languages);
        model.addAttribute("pageSizes",pageSizes);
        model.addAttribute("spamFilers",spamFilers);
        model.addAttribute("email", new Email());
        return "setting";
    }

    @RequestMapping(value = "/addEmail", method = RequestMethod.POST)
    public String submit(@ModelAttribute("email") Email email, Model model) {
//        model.addAttribute("email", email);
        model.addAttribute("languages", email.getLanguage());
        model.addAttribute("pageSizes", email.getPageSize());
        model.addAttribute("spamFilers", email.getSpamFiler());
        model.addAttribute("signature", email.getSignature());
        return "infor";
    }
}
