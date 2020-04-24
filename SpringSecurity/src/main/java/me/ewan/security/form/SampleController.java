package me.ewan.security.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class SampleController {

    @Autowired
    SampleService sampleService;

    @GetMapping("/")
    public String index(Model model, Principal principal){
        if(principal == null){
            model.addAttribute("message", "hello !");
        }else {
            model.addAttribute("message", "hello !" + principal.getName());
        }
        return "index";
    }

    @GetMapping("/info")
    public String info(Model model){
        model.addAttribute("message", "hello");
        return "info";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal){
        model.addAttribute("message", "hello !" + principal.getName());
        sampleService.dashBoard();
        return "dashboard";
    }

    @GetMapping("/admin")
    public String admin(Model model, Principal principal){
        model.addAttribute("message", "hello admin" + principal.getName());
        return "admin";
    }
}
