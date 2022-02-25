package com.exemple.gestion_employer1.controller;



import com.exemple.gestion_employer1.entity.EmployerEntity;
import com.exemple.gestion_employer1.services.ServiceInt;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public String insertUser(@ModelAttribute("employer") EmployerEntity employer, HttpServletRequest request){
        employer.getRole().setId_role(Long.parseLong(request.getParameter("role")));
        serviceEmployer.add(employer);
        return "redirect:list";
    }
    @GetMapping("edit/{id_user}")
    public String showEditForm(@PathVariable("id_user") long id,Model theModel){
        EmployerEntity employer = serviceEmployer.find(id);
        theModel.addAttribute("employer",employer);
        return "editeUser";
    }
    @PostMapping("update")
    public String updateStudent(@Valid EmployerEntity employer, HttpServletRequest request){
        employer.getRole().setId_role(Long.parseLong(request.getParameter("role")));
        System.out.println("Epdating employee: "+employer);
        try{
            serviceEmployer.update(employer);
        }catch (HibernateException e){
            System.out.println("Can't update employee");
            System.out.println(e.getMessage());
        }
        return "redirect:list";
    }
    @GetMapping("delete/{id_user}")
    public String deleteUser(@PathVariable("id_user") long id){
        System.out.println("Delete id:"+id);
        serviceEmployer.delete(id);
        return "redirect:/list";
    }



//    @RequestMapping("/add")
//    @ResponseBody
//    public String addEmp(){
//        return "hello";
//    }


}
