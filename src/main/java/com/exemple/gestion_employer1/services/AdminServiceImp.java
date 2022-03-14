package com.exemple.gestion_employer1.services;

import com.exemple.gestion_employer1.dao.AdminDaoImp;
import com.exemple.gestion_employer1.entity.AdminEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImp implements ServiceInt<AdminEntity> {
    private AdminDaoImp adminDaoImp;

    @Autowired
    public AdminServiceImp(AdminDaoImp adminDaoImp){
        this.adminDaoImp = adminDaoImp;
    }


    @Override
    public AdminEntity add(AdminEntity admin) {
        return adminDaoImp.add(admin);
    }

    @Override
    public AdminEntity find(long id) {
        return adminDaoImp.find(id);
    }

    @Override
    public List<AdminEntity> getAll() {
        return adminDaoImp.getAll();
    }

    @Override
    public AdminEntity update(AdminEntity admin) {
        return adminDaoImp.update(admin);
    }

    @Override
    public boolean delete(long id) {
        return adminDaoImp.delete(id);
    }
}
