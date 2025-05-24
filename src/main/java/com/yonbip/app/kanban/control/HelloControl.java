package com.yonbip.app.kanban.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;

@Controller
public class HelloControl {

    @PostConstruct
    public void init() {
        System.out.println("HelloControl init successful.");
    }

    @GetMapping(path = "/index")
    public String index(Model model) {
        model.addAttribute("text", "HelloWorld");
        return "index";
    }
}
