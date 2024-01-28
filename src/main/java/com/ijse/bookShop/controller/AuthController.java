package com.ijse.bookShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.bookShop.dto.UserDto;
import com.ijse.bookShop.entity.UserEntity;
import com.ijse.bookShop.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@CrossOrigin(origins = "*") 

public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
        
        try {
            return ResponseEntity.created(null).body(userService.createUSer(userDto));
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        
    }

    @GetMapping("/user")
    public ResponseEntity<?> getAllUSer() {
        try {
            return ResponseEntity.ok().body(userService.getAllUsers());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("null");
        }
    }


    @PutMapping("user/{id}/change-password")
    public ResponseEntity<?> changePassword(@PathVariable Long id, @RequestBody UserDto userDto) {
       try {
        return ResponseEntity.ok().body(userService.changeUserPasword(id, userDto));
       } catch (Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
       }
    }
    
    


    
    
}
