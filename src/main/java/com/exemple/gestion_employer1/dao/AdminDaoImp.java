package com.exemple.gestion_employer1.dao;

import com.exemple.gestion_employer1.entity.AdminEntity;
import com.exemple.gestion_employer1.entity.EmployerEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminDaoImp implements DAOInt<AdminEntity> {
    private AdminEntity admin;
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    public AdminDaoImp(AdminEntity admin){
        this.admin = admin;
    }
    @Override
    public AdminEntity add(AdminEntity admin){
        Session session = sessionFactory.getCurrentSession();
        session.save(admin);
        return admin;
    }
    @Override
    public AdminEntity find(long id){
        Session session = sessionFactory.getCurrentSession();
        AdminEntity admin = session.get(AdminEntity.class,id);
        return admin;
    }
    @Override
    public List<AdminEntity> getAll(){
//        Session session = HSessionFactory.getInstance().getSession().openSession();
//        session.beginTransaction();
//        List<AdminEntity> admins = session.createCriteria(AdminEntity.class).list();
//        session.close();
        Session session=sessionFactory.getCurrentSession();
        List<AdminEntity>admins = session.createCriteria(AdminEntity.class).list();
        return admins;
    }
    @Override
    public  AdminEntity update(AdminEntity admin){
//        Session session = HSessionFactory.getInstance().getSession().openSession();
//        session.beginTransaction();
//        session.merge(admin);
//        session.getTransaction().commit();
//        session.close();
       Session session = sessionFactory.getCurrentSession();
       session.saveOrUpdate(admin);

        return admin;
    }
    @Override
    public boolean delete(long id){
//        Session session = HSessionFactory.getInstance().getSession().openSession();
//        session.beginTransaction();
//        AdminEntity admin = session.find(AdminEntity.class,id);
//        session.delete(admin);
//        session.getTransaction().commit();
//        session.close();
        Session session = sessionFactory.getCurrentSession();
        AdminEntity admin = session.get(AdminEntity.class,id);
        session.delete(admin);
        return true;
    }

}
