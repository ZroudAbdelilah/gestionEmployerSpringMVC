package com.exemple.gestion_employer1.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;
@Component
@Entity
@Table(name="role")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_role")
    private Long id_role;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL)
    private Set<UserEntity> users;

    public Long getId_role() {
        return id_role;
    }

    public void setId_role(Long id_role) {
        this.id_role = id_role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoleEntity() {
    }

    public RoleEntity(Long id_role, String name) {
        this.id_role = id_role;
        this.name = name;
    }


    public RoleEntity(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RoleEntity{" +
                "id_role=" + id_role +
                ", name='" + name + '\'' +
                ", users=" + users +
                '}';
    }
}
