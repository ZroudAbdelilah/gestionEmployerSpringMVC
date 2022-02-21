package com.exemple.gestion_employer1.dao;

import com.exemple.gestion_employer1.entity.AdminEntity;
import com.exemple.gestion_employer1.hibernate.HSessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminDaoImp implements DAOInt<AdminEntity> {
    private AdminEntity admin;
    Session session = HSessionFactory.getInstance().getSession().openSession();
    @Autowired
    public AdminDaoImp(AdminEntity admin){
        this.admin = admin;
    }
    @Override
    public AdminEntity add(AdminEntity admin){
        session.beginTransaction();
        admin.setId_user((long)session.save(admin));
        session.getTransaction().commit();
        session.close();
        return admin;
    }
    @Override
    public AdminEntity find(long id){
        session.beginTransaction();
        AdminEntity admin = session.find(AdminEntity.class,id);
        session.close();
        return admin;
    }
    @Override
    public List<AdminEntity> getAll(){
        session.beginTransaction();
        List<AdminEntity> admins = session.createCriteria(AdminEntity.class).list();
        session.close();
        return admins;
    }
    @Override
    public  AdminEntity update(AdminEntity admin){
        session.beginTransaction();
        session.merge(admin);
        session.getTransaction().commit();
        session.close();
        return admin;
    }
    @Override
    public boolean delete(long id){
        session.beginTransaction();
        AdminEntity admin = session.find(AdminEntity.class,id);
        session.delete(admin);
        session.getTransaction().commit();
        return true;
    }

}
