package com.fundappcion.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class mainController {

    @RequestMapping(value = "/")
    public ModelAndView swaggerEndPoint() {
        return new ModelAndView("redirect:/swagger-ui.html#/");
    }
}
