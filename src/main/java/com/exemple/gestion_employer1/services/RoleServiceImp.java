package com.exemple.gestion_employer1.services;

import com.exemple.gestion_employer1.dao.EmployerDaoImp;
import com.exemple.gestion_employer1.dao.RoleDaoImp;
import com.exemple.gestion_employer1.entity.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImp implements ServiceInt<RoleEntity> {
    private RoleDaoImp roleDaoImp;
    @Autowired
    public RoleServiceImp(RoleDaoImp roleDaoImp){
        this.roleDaoImp = roleDaoImp;
    }
    @Override
    public RoleEntity add(RoleEntity role) {
        return roleDaoImp.add(role);
    }

    @Override
    public RoleEntity find(long id) {
        return roleDaoImp.find(id);
    }

    @Override
    public List<RoleEntity> getAll() {
        return roleDaoImp.getAll();
    }

    @Override
    public RoleEntity update(RoleEntity role) {
        return roleDaoImp.update(role);
    }

    @Override
    public boolean delete(long id) {
        return roleDaoImp.delete(id);
    }
}
