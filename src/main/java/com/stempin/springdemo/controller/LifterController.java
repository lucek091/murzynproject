package com.stempin.springdemo.controller;

import com.stempin.springdemo.dao.ILifterDAO;
import com.stempin.springdemo.entity.Lifter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/lifter")
public class LifterController {

    @Autowired
    private ILifterDAO iLifterDAO;

    @RequestMapping("/list")
    public String listLifters(Model theModel) {
        //get lifters from the dao
        List<Lifter> theLifters = iLifterDAO.getLifters();

        //add the lifters to the model
        theModel.addAttribute("lifters", theLifters);

        return "list-lifters";
    }

}
