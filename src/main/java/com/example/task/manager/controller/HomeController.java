package com.example.task.manager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class HomeController {
    @GetMapping(value = "/trang-chu")
    public ModelAndView homePage() {
        ModelAndView mav = new ModelAndView("home");
        return mav;

    }
}
