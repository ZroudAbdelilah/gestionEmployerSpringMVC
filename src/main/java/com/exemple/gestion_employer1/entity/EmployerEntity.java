package com.exemple.gestion_employer1.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
@Component
@Entity
@Table(name = "employer")
public class EmployerEntity extends UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id_user;


    public EmployerEntity(String first_name, String last_name, String email, String password, RoleEntity role) {
        super(first_name, last_name, email, password, role);
    }

    public EmployerEntity() {
    }

    public EmployerEntity(String first_name, String last_name, String email, String password, RoleEntity role, Long id_user) {
        super(first_name, last_name, email, password, role);
        this.id_user = id_user;
    }

    @Override
    public Long getId_user() {
        return id_user;
    }

    @Override
    public void setId_user(Long id_user) {
        super.setId_user(id_user);
        this.id_user = id_user;
    }


    @Override
    public String toString() {
        return super.toString()+"EmployerEntity{" +
                "id_user=" + id_user +
                '}';
    }
}
