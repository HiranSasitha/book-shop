package com.ijse.bookShop.controller;

import org.springframework.web.bind.annotation.RestController;


import com.ijse.bookShop.dto.LogingDto;
import com.ijse.bookShop.dto.UserDto;
import com.ijse.bookShop.entity.UserEntity;
import com.ijse.bookShop.repository.UserRepository;
import com.ijse.bookShop.security.jwt.JwtUtils;
import com.ijse.bookShop.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@CrossOrigin(origins = "*")

public class AuthController {

@Autowired
private UserRepository userRepository;

@Autowired
private UserService userService;

@Autowired
PasswordEncoder passwordEncoder;

@Autowired
private AuthenticationManager authenticationManager;

@Autowired
private JwtUtils jwtUtils;


    

@PostMapping("/auth/rgister")
public ResponseEntity<?> postMethodName(@RequestBody UserDto userDto) throws Exception {
    
    if(userRepository.existsByUserName(userDto.getUserName())){
        return ResponseEntity.badRequest().body("Username Is already in use");
    }

    if(userRepository.existsByEmail(userDto.getEmail())){
        return ResponseEntity.badRequest().body("Email is already in use");
    }

    UserDto newUser = new UserDto();
    
    newUser.setUserName(userDto.getUserName());
    newUser.setEmail(userDto.getEmail());
    
    // Encode the password before setting it in the UserDto
    newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));

    newUser.setAddress(userDto.getAddress());
    newUser.setUserCategoryId(userDto.getUserCategoryId());

    return ResponseEntity.ok().body(userService.createUSer(newUser));
}


    @PostMapping("/auth/loging")
    public ResponseEntity<?> login(@RequestBody LogingDto request)  {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);

        
        return ResponseEntity.ok(jwt);
    }

    @GetMapping("/auth/{userName}")
    public ResponseEntity<?> getUserEntityByUserName(@PathVariable String userName) throws Exception {
        return ResponseEntity.ok().body(userService.getUserById(userName));
    }

    @GetMapping("/auth/usersd")
    public ResponseEntity<?> getAllUsers() throws Exception {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }
    
    
    
    
    
}
