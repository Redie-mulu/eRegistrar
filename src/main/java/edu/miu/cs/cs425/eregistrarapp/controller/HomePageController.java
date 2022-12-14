package edu.miu.cs.cs425.eregistrarapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"", "/", "/eregistrar"})
public class HomePageController {
    @GetMapping(value = {"","home"})
    public String displayHomePage() {
        return "index";
    }
    @GetMapping(value = {"/about"})
    public String displayAboutUsPage() {
        return "about";
    }

}
