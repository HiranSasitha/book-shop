package com.ijse.bookShop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.bookShop.dto.OrderDto;
import com.ijse.bookShop.entity.OrderEntity;
import com.ijse.bookShop.entity.OrderItemsEntity;

@Service

public interface OrderService {

    List<OrderEntity> getAllOrder() throws Exception;
    OrderEntity getOrderById(Long id) throws Exception;
    List<OrderItemsEntity>createOrders(OrderDto orderDto) throws Exception;

    
}
