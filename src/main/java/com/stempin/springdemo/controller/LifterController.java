package com.stempin.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lifter")
public class LifterController {

    @RequestMapping("/list")
    public String listLifters(Model theModel) {

        return "list-lifters";
    }

}
