package com.base.datos.springbootdatajpa.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("home")
public class homeController {

    @GetMapping("/")
    public ModelAndView home()
    {
        ModelAndView modelAndView = new ModelAndView("home/home");

        modelAndView.addObject("titlePage", "home");
        modelAndView.addObject("titulo", "welcome back");

        return modelAndView;
    }
    
}
