package com.exemple.gestion_employer1.services;

import com.exemple.gestion_employer1.dao.AdminRepoInt;
import com.exemple.gestion_employer1.dao.EmployerDaoImp;
import com.exemple.gestion_employer1.entity.EmployerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployerServiceImp implements ServiceInt<EmployerEntity> {
    private EmployerDaoImp employerDaoImp;

    @Autowired
    private AdminRepoInt adminRepoInt;
    @Autowired
    public EmployerServiceImp(EmployerDaoImp employerDaoImp){
        this.employerDaoImp = employerDaoImp;
    }
    @Override
    public EmployerEntity add(EmployerEntity employer) {
        return employerDaoImp.add(employer);
    }

    @Override
    public EmployerEntity find(long id) {
        return employerDaoImp.find(id);
    }

    @Override
    public List<EmployerEntity> getAll() {
//        List<EmployerEntity> employers = employerDaoImp.getAll();
//        return employers;
        return employerDaoImp.getAll();
    }

    @Override
    public EmployerEntity update(EmployerEntity employer) {
        return employerDaoImp.update(employer);
    }

    @Override
    public boolean delete(long id) {
        return employerDaoImp.delete(id);
    }
    @Transactional
    public boolean islogged(String email, String password) throws Exception {
        if(adminRepoInt.validate(email,password)) {
            return true;
        } else {
            return false;
        }


    }

}
