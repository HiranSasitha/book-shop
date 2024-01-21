package com.ijse.bookShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ijse.bookShop.entity.ItemCategoryEntity;
import com.ijse.bookShop.entity.ItemEntity;
@Repository

public interface ItemRepository extends JpaRepository<ItemEntity,Long> {

    @Query("SELECT p from ItemEntity p WHERE p.itemCategoryEntity =:itemCategoryEntity")
    List<ItemEntity> findItemByCategory(@Param("itemCategoryEntity") ItemCategoryEntity itemCategoryEntity);

    
}
