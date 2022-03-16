package com.exemple.gestion_employer1.dao;

import com.exemple.gestion_employer1.entity.AdminEntity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepoImp implements AdminRepoInt{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public boolean validate(String email, String password) {
        Transaction transaction = null;
        AdminEntity admin = null;
        try (Session session = sessionFactory.getCurrentSession();) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            admin = (AdminEntity) session.createQuery("FROM AdminEntity A WHERE A.email = :email").setParameter("email", email)
                    .uniqueResult();

            if (admin != null && admin.getPassword().equals(password)) {
                return true;
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }
}
