package com.ijse.bookShop.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity

@Table(name = "orders")
@Data



public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Temporal(TemporalType.TIMESTAMP)  // get current time when place order
    private LocalDateTime orderTime;


    @Column(nullable = false)
    private Double total;

    @Column(nullable = false,name = "tax(%)")
    private Double tax;

    @Column(name ="discount(%)")
    private Double discount;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private UserEntity userEntity;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "orderEntity",targetEntity = OrderItemsEntity.class,cascade = CascadeType.ALL)
    private Set<OrderItemsEntity>orderItemsEntities = new HashSet<>();

   

    
}
