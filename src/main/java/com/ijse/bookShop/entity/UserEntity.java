package com.ijse.bookShop.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.ManyToAny;
import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user")
@Data

public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String userName;

    @Column(unique = true,nullable = false)
    private String password;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(nullable = false)
    private String address;



    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private UserCategoryEntity userCategoryEntity;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "userEntity",targetEntity = OrderEntity.class,cascade = CascadeType.ALL)
    private Set<OrderEntity>orderEntities = new HashSet<>();


    
    
}
