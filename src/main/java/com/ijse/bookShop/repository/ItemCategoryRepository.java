package com.ijse.bookShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.bookShop.entity.ItemCategoryEntity;

@Repository

public interface ItemCategoryRepository extends JpaRepository<ItemCategoryEntity,Long> {
    
}
