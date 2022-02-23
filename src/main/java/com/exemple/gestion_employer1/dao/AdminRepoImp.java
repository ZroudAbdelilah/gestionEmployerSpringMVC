package com.exemple.gestion_employer1.dao;

import com.exemple.gestion_employer1.entity.AdminEntity;
import com.exemple.gestion_employer1.hibernate.HSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepoImp implements AdminRepoInt{
    @Override
    public boolean validate(String email, String password) {
        Transaction transaction = null;
        AdminEntity admin = null;
        try (Session session = HSessionFactory.getInstance().getSession().openSession()) {
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
