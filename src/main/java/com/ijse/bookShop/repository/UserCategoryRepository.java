package com.ijse.bookShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ijse.bookShop.entity.UserCategoryEntity;

public interface UserCategoryRepository extends JpaRepository<UserCategoryEntity,Long> {
    
}
