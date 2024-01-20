package com.ijse.bookShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.bookShop.entity.UserCategoryEntity;

@Repository

public interface UserCategoryRepository extends JpaRepository<UserCategoryEntity,Long> {
    
}
