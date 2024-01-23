package com.ijse.bookShop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "order_item")
@Data
public class OrderItemsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer qty;

    @Column(nullable = false)
    private Double discount;

    @ManyToOne
    @JoinColumn(name = "order_id",nullable = false)
    private OrderEntity orderEntity;

    @ManyToOne
    @JoinColumn(name = "item_id",nullable = false)
    private ItemEntity itemEntity;

    
}
