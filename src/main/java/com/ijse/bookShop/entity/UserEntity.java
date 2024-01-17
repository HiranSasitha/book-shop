package com.ijse.bookShop.entity;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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


    
    
}
