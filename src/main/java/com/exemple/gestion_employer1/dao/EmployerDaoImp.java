package com.exemple.gestion_employer1.dao;

import com.exemple.gestion_employer1.entity.EmployerEntity;
import com.exemple.gestion_employer1.hibernate.HSessionFactory;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployerDaoImp implements  DAOInt<EmployerEntity> {


    @Override
    public EmployerEntity add(EmployerEntity employer) {
        Session session = HSessionFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        session.save(employer);
        session.beginTransaction().commit();
        session.close();

        return employer;
    }

    @Override
    public EmployerEntity find(long id) {
        Session session = HSessionFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        EmployerEntity employer = session.find(EmployerEntity.class,id);
        session.close();
        return employer;
    }

    @Override
    public List<EmployerEntity> getAll() {
        Session session = HSessionFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        List<EmployerEntity> employers = session.createCriteria(EmployerEntity.class).list();
        session.close();
        return employers;
    }

    @Override
    public EmployerEntity update(EmployerEntity employer) {
        Session session = HSessionFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        session.load(EmployerEntity.class,employer.getId_user());
        session.close();
        return employer;
    }

    @Override
    public boolean delete(long id) {
        Session session = HSessionFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        EmployerEntity employer =session.find(EmployerEntity.class,id);
        session.delete(employer);
        session.close();
        return true;
    }
}