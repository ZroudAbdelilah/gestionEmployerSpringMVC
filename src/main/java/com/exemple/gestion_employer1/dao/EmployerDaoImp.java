package com.exemple.gestion_employer1.dao;

import com.exemple.gestion_employer1.entity.EmployerEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployerDaoImp implements  DAOInt<EmployerEntity> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public EmployerEntity add(EmployerEntity employer) {
//        System.out.println(employer);
//        Session session = HSessionFactory.getInstance().getSession().openSession();
//        session.beginTransaction();
//        session.save(employer);
//        session.getTransaction().commit();
//        session.close();
//        return employer;
        Session session = sessionFactory.getCurrentSession();
        session.save(employer);
        return employer;
    }

    @Override
    public EmployerEntity find(long id) {
//        Session session = HSessionFactory.getInstance().getSession().openSession();
//        session.beginTransaction();
//        EmployerEntity employer = session.find(EmployerEntity.class,id);
//        session.getTransaction().commit();
//        session.close();
//        return employer;
        Session session = sessionFactory.getCurrentSession();
        EmployerEntity employer = session.get(EmployerEntity.class,id);
        return employer;
    }

    @Override
    public List<EmployerEntity> getAll() {
       // List<EmployerEntity> employers  = HSessionFactory.getInstance().getSession().openSession().createCriteria(EmployerEntity.class).list();
//        session.beginTransaction();
//        List<EmployerEntity> employers = session.createCriteria(EmployerEntity.class).list();
//        session.close();
        Session session=sessionFactory.getCurrentSession();
        List<EmployerEntity> employers = session.createCriteria(EmployerEntity.class).list();


        return employers;
    }

    @Override
    public EmployerEntity update(EmployerEntity employer) {
//        Session session = HSessionFactory.getInstance().getSession().openSession();
//        session.beginTransaction();
//        session.load(EmployerEntity.class,employer.getId_user());
//        session.merge(employer);
//        session.getTransaction().commit();
//        session.close();
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employer);
        return employer;
    }

    @Override
    public boolean delete(long id) {
//        Session session = HSessionFactory.getInstance().getSession().openSession();
//        session.beginTransaction();
//        EmployerEntity employer =session.find(EmployerEntity.class,id);
//        session.delete(employer);
//        session.getTransaction().commit();
//        session.close();
            Session session = sessionFactory.getCurrentSession();
            EmployerEntity employer = session.get(EmployerEntity.class,id);
            session.delete(employer);
        return true;
    }
}
