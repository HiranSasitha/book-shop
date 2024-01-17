package com.ijse.bookShop.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user_category")
@Data

public class UserCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true , nullable = false)
    private String userType;
    
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "userCategoryEntity",targetEntity = UserEntity.class,cascade = CascadeType.ALL)

    private Set<UserEntity> userEntites = new HashSet<>();
}
