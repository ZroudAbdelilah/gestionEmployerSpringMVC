package com.exemple.gestion_employer1.dao;

import com.exemple.gestion_employer1.entity.RoleEntity;
import com.exemple.gestion_employer1.hibernate.HSessionFactory;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RoleDaoImp implements DAOInt<RoleEntity> {
    RoleEntity role;

    @Override
    public RoleEntity add(RoleEntity role) {
        Session session = HSessionFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        session.save(role);
        session.getTransaction().commit();
        session.close();
        return role;
    }

    @Override
    public RoleEntity find(long id) {
        Session session = HSessionFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        RoleEntity role = session.get(RoleEntity.class,id);
        session.close();
        return role;
    }

    @Override
    public List<RoleEntity> getAll() {
        Session session = HSessionFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        ArrayList<RoleEntity> roles = (ArrayList<RoleEntity>)session.createCriteria(RoleEntity.class).list();
        session.close();
        return roles;
    }

    @Override
    public RoleEntity update(RoleEntity object) {
        Session session = HSessionFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        session.find(RoleEntity.class,role.getId_role());
        session.merge(role);
        session.getTransaction().commit();
        session.close();
        return role;
    }

    @Override
    public boolean delete(long id) {
        Session session = HSessionFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        RoleEntity roleEntity = session.load(RoleEntity.class,id);
        session.delete(roleEntity);
        session.getTransaction().commit();
        session.close();
        return true;
    }
}
