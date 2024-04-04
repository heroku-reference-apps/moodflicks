package com.heroku.movieservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin
public class HomeController {
    @GetMapping(value = "/")
    public String index() {
        return "index.html";
    }
}
