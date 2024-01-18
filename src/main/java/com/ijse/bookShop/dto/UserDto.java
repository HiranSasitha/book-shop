package com.ijse.bookShop.dto;

import lombok.Data;

@Data

public class UserDto {

    private Long userCategoryId;

    private String userName;

    private String password;

    private String email;

    private String address;

}
