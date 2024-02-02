package com.ijse.bookShop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.bookShop.dto.UserDto;
import com.ijse.bookShop.entity.UserEntity;

@Service

public interface UserService {
    List<UserEntity> getAllUsers() throws Exception;
    UserEntity createUSer(UserDto userDto) throws Exception;
    UserEntity getUserById(String userName) throws Exception;
    UserEntity changeUserPasword(Long id,UserDto userDto) throws Exception;

    
}
