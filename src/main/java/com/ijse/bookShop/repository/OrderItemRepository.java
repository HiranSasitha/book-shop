package com.ijse.bookShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.bookShop.entity.OrderItemsEntity;
@Repository

public interface OrderItemRepository extends JpaRepository<OrderItemsEntity,Long> {
    
}
