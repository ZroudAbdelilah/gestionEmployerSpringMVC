package com.exemple.gestion_employer1.controller;



import com.exemple.gestion_employer1.entity.EmployerEntity;
import com.exemple.gestion_employer1.services.ServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


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
        theModel.addAttribute("employers",serviceEmployer.getAll());
        //List <EmployerEntity> theEmployers = serviceEmployer.getAll();
        return "listeEmployer";
    }

    @GetMapping("new")
    public String showNewForm(Model theModel){
        EmployerEntity employer= new EmployerEntity();
        theModel.addAttribute("employer",employer);
        return "addEmployer";
    }
    @PostMapping("insert")
    public String insertUser(@ModelAttribute("employer") EmployerEntity employer){
        serviceEmployer.add(employer);
        return "redirect:list";
    }
    @GetMapping("edit/{id_user}")
    public String showEditForm(@RequestParam("id_user") Long id,Model theModel){
        EmployerEntity employer = serviceEmployer.find(id);
        theModel.addAttribute("employer",employer);
        return "editeUser";
    }
    @PostMapping("update")
    public String updateStudent(@Valid EmployerEntity employer, BindingResult result) {
        serviceEmployer.update(employer);
        return "redirect:/";
    }
    @GetMapping("delete")
    public String deleteUser(@RequestParam("user_id") Long id){
        serviceEmployer.delete(id);
        return "redirect:list";
    }



//    @RequestMapping("/add")
//    @ResponseBody
//    public String addEmp(){
//        return "hello";
//    }


}
