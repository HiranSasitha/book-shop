package com.ijse.bookShop.dto;

import java.util.List;

import lombok.Data;
@Data

public class OrderDto {

    private Long userId;
    private List<OrderItemDto>orderItemDtos;
    
}
