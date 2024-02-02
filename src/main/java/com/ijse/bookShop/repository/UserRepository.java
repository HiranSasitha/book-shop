package com.ijse.bookShop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.bookShop.entity.UserEntity;

@Repository

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByUserName (String userName);

    Boolean existsByUserName(String userName);
 
 
    Boolean existsByEmail (String email);
    
}
