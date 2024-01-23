package com.ijse.bookShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ijse.bookShop.entity.OrderEntity;
@Repository

public interface OrderRepository extends JpaRepository<OrderEntity,Long> {

  //  @Query("SELECT MAX(id) FROM OrderEntity")
   // Long findMaxId();
    
}
