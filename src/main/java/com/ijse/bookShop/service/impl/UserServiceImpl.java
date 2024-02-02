package com.ijse.bookShop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.bookShop.dto.UserDto;
import com.ijse.bookShop.entity.UserCategoryEntity;
import com.ijse.bookShop.entity.UserEntity;
import com.ijse.bookShop.repository.UserCategoryRepository;
import com.ijse.bookShop.repository.UserRepository;
import com.ijse.bookShop.service.UserService;

@Service

public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserCategoryRepository userCategoryRepository;

    @Override
    public List<UserEntity> getAllUsers() throws Exception {
        return userRepository.findAll();
    }

    @Override
    public UserEntity createUSer(UserDto userDto) throws Exception {


        UserCategoryEntity userCategoryEntity = userCategoryRepository.findById(userDto.getUserCategoryId()).orElse(null);
        

        if(userCategoryEntity != null){

        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userDto.getUserName());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setAddress(userDto.getAddress());
        userEntity.setUserCategoryEntity(userCategoryEntity);

        return userRepository.save(userEntity);

        }


        return null;
    }

    @Override
    public UserEntity getUserById(String userName) throws Exception {
      
        return userRepository.findByUserName(userName).orElse(null);
    }

    @Override
    public UserEntity changeUserPasword(Long id, UserDto userDto) throws Exception {
       
        UserEntity userEntity = userRepository.findById(id).orElse(null);

        if(userEntity != null){
            userEntity.setPassword(userDto.getPassword());
            return userRepository.save(userEntity);
        }

        return null;
    
    }
    
}
