package com.stempin.springdemo.controller;

import com.stempin.springdemo.entity.Lifter;
import com.stempin.springdemo.service.ILifterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/lifter")
public class LifterController {

    @Autowired
    private ILifterService iLifterService;

    @GetMapping("/list")
    public String listLifters(Model theModel) {
        //get lifters from the service
        List<Lifter> theLifters = iLifterService.getLifters();

        //add the lifters to the model
        theModel.addAttribute("lifters", theLifters);

        return "list-lifters";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd (Model theModel) {
        Lifter lifter = new Lifter();
        theModel.addAttribute("lifter", lifter);
        return "lifter-form";
    }

    @PostMapping("/saveLifter")
    public String saveLifter(@ModelAttribute("lifter") Lifter theLifter) {
        iLifterService.saveLifter(theLifter);
        return "redirect:/lifter/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate (@RequestParam("lifterId") int theId, Model theModel) {
        //get the lifter from the service
        Lifter lifter = iLifterService.getLifter(theId);

        //set the lifter as a model attribute to pre-populate the form
        theModel.addAttribute("lifter", lifter);

        //send over to our form
        return "lifter-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("lifterId") int theId) {
        //delete the lifter
        iLifterService.deleteLifter(theId);


        return "redirect:/lifter/list";
    }

    @PostMapping("/search")
    public String searchLifter(@RequestParam("theSearchName")String theSearchName, Model theModel) {
        List<Lifter> theLifters = iLifterService.searchLifter(theSearchName);
        theModel.addAttribute("lifters", theLifters);
        return "list-lifters";
    }



}
