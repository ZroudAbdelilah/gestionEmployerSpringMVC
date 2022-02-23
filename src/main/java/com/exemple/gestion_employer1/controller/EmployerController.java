package com.exemple.gestion_employer1.controller;


import com.exemple.gestion_employer1.dao.AdminRepoImp;
import com.exemple.gestion_employer1.dao.AdminRepoInt;
import com.exemple.gestion_employer1.dao.DAOInt;
import com.exemple.gestion_employer1.dao.EmployerDaoImp;
import com.exemple.gestion_employer1.entity.EmployerEntity;
import com.exemple.gestion_employer1.services.ServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/")
public class EmployerController {

    private ServiceInt<EmployerEntity> serviceEmployer;

    @Autowired
    public EmployerController(ServiceInt<EmployerEntity> serviceEmployer) {
        this.serviceEmployer = serviceEmployer;
    }

    @GetMapping("list")
    public String listUser (Model theModel){
        List <EmployerEntity> theEmployers = serviceEmployer.getAll();
        return "listeEmployer";
    }

    @GetMapping("new")
    public String showNewForm(Model theModel,HttpServletRequest request){
        EmployerEntity theEmployer = new EmployerEntity();
        theModel.addAttribute("employer",theEmployer);
        return "addEmployer";
    }
    @PostMapping("insert")
    public String insertUser(@ModelAttribute("employer") EmployerEntity theEmployer){
        serviceEmployer.add(theEmployer);
        return "redirect:list";
    }
    @GetMapping("edit")
    public String showEditForm(@RequestParam("id_user") Long theId,Model theModel){
        EmployerEntity theEmployer = serviceEmployer.find(theId);
        theModel.addAttribute("employer",theEmployer);
        return "editeUser";
    }
    @GetMapping("delete")
    public String deleteUser(@RequestParam("user_id") Long theId){
        serviceEmployer.delete(theId);
        return "redirect:list";
    }



//    @RequestMapping("/add")
//    @ResponseBody
//    public String addEmp(){
//        return "hello";
//    }


}
