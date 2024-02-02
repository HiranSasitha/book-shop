package com.ijse.bookShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.bookShop.dto.OrderDto;
import com.ijse.bookShop.service.OrderService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@CrossOrigin(origins = "*") 

public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/admin/order")
    public ResponseEntity<?> getAllOrders()  {
        try {
            return ResponseEntity.ok().body(orderService.getAllOrder());
        } catch (Exception e) {
          return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/admin/order/{id}")
    public ResponseEntity<?> getOrderByid(@PathVariable Long id)  {
        try {
            return ResponseEntity.ok().body(orderService.getOrderById(id));
        } catch (Exception e) {
          return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PostMapping("/user/order")
    public ResponseEntity<?> createOrder(@RequestBody OrderDto orderDto) {
       try {
        return ResponseEntity.ok().body(orderService.createOrders(orderDto));
       } catch (Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
       }
    }
    


    
    
}
