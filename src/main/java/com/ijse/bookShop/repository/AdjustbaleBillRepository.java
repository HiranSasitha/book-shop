package com.ijse.bookShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.bookShop.entity.AdjustableBillEntity;
@Repository

public interface AdjustbaleBillRepository extends JpaRepository<AdjustableBillEntity,Long> {
    
}
