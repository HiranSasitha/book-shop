package com.ijse.bookShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ijse.bookShop.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    
}
