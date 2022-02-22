package com.exemple.gestion_employer1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployerController {

    @RequestMapping("/add")
    @ResponseBody
    public String addEmp(){
        return "hello";
    }

}
