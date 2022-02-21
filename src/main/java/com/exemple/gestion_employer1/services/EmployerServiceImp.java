package com.exemple.gestion_employer1.services;

import com.exemple.gestion_employer1.dao.EmployerDaoImp;
import com.exemple.gestion_employer1.entity.EmployerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerServiceImp implements ServiceInt<EmployerEntity> {
    private EmployerDaoImp employerDaoImp;
    @Autowired
    public EmployerServiceImp(EmployerDaoImp employerDaoImp){
        this.employerDaoImp = employerDaoImp;
    }
    @Override
    public EmployerEntity add(EmployerEntity employer) {
        return employerDaoImp.add(employer);
    }

    @Override
    public EmployerEntity Find(long id) {
        return employerDaoImp.find(id);
    }

    @Override
    public List<EmployerEntity> getAll() {
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
}
