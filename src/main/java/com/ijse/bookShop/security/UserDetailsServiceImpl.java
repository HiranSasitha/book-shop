package com.ijse.bookShop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ijse.bookShop.entity.UserCategoryEntity;
import com.ijse.bookShop.entity.UserEntity;
import com.ijse.bookShop.repository.UserRepository;

import java.util.Collection;
import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findByUserName(username).orElse(null);

        if (userEntity == null) {
            throw new UsernameNotFoundException("User Not Found");
        }

        Collection<GrantedAuthority> authorities = getAuthorities(userEntity.getUserCategoryEntity());

        return User.builder()
                .username(userEntity.getUserName())
                .password(userEntity.getPassword())
                .authorities(authorities)
                .build();
    }

    private Collection<GrantedAuthority> getAuthorities(UserCategoryEntity userCategoryEntity) {
        
        String roleName = userCategoryEntity.getUserType();
        return Collections.singleton(new SimpleGrantedAuthority(roleName));
    }
}
