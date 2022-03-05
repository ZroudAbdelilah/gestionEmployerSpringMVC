package com.exemple.gestion_employer1.controller;



import com.exemple.gestion_employer1.entity.EmployerEntity;
import com.exemple.gestion_employer1.entity.UserEntity;
import com.exemple.gestion_employer1.services.EmployerServiceImp;
import com.exemple.gestion_employer1.services.ServiceInt;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
@RequestMapping("/")
public class EmployerController {

    private ServiceInt<EmployerEntity> serviceEmployer;
    @Autowired
    private EmployerEntity employer;
    @Autowired
    private UserEntity userEntity;
    @Autowired
    private EmployerServiceImp employerServiceImp;
    @Autowired
    public EmployerController(ServiceInt<EmployerEntity> serviceEmployer) {
        this.serviceEmployer = serviceEmployer;
    }

    @GetMapping("/admin/list")
    public String listUser (Model theModel){
        theModel.addAttribute("employers",serviceEmployer.getAll());
        //List <EmployerEntity> theEmployers = serviceEmployer.getAll();
        return "listeEmployer";
    }

    @GetMapping("/admin/new")
    public String showNewForm(Model theModel){

        theModel.addAttribute("employer",employer);
        return "addEmployer";
    }
    @PostMapping("/admin/insert")
    public String insertUser(@ModelAttribute("employer") EmployerEntity employer, HttpServletRequest request){
        employer.getRole().setId_role(Long.parseLong(request.getParameter("role")));
        serviceEmployer.add(employer);
        return "redirect:/admin/list";
    }
    @GetMapping("/admin/edit/{id_user}")
    public String showEditForm(@PathVariable("id_user") long id,Model theModel){
        EmployerEntity employer = serviceEmployer.find(id);
        theModel.addAttribute("employer",employer);
        return "editeUser";
    }
    @PostMapping("/admin/update")
    public String updateStudent(@Valid EmployerEntity employer, HttpServletRequest request){
        employer.getRole().setId_role(Long.parseLong(request.getParameter("role")));
        System.out.println("Epdating employee: "+employer);
        try{
            serviceEmployer.update(employer);
        }catch (HibernateException e){
            System.out.println("Can't update employee");
            System.out.println(e.getMessage());
        }
        return "redirect:/admin/list";
    }
    @GetMapping("/admin/delete/{id_user}")
    public String deleteUser(@PathVariable("id_user") long id){
        System.out.println("Delete id:"+id);
        serviceEmployer.delete(id);
        return "redirect:/admin/list";
    }
    @GetMapping("/")
    public String showLogin(Model model) {
        model.addAttribute("user", userEntity );
        return "login";
    }
    @PostMapping(value = "/login")
    public String authentication (@Valid UserEntity user, HttpSession session, BindingResult result, ModelMap map, Model model) throws Exception{
        String email =user.getEmail();
        String password = user.getPassword();
        if( employerServiceImp.islogged(email, password)) {
            session.setAttribute("email", email);
            session.setAttribute("password", password);
            return "redirect:/admin/list";
        } else  {
            model.addAttribute("user", user);
            model.addAttribute("denied", "Warning, Email ou mot de passe est incorrect!");
            return "login";
        }

    }





}
