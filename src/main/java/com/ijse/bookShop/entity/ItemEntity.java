package com.ijse.bookShop.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "item")
@Data

public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String discription;

    @Column(nullable = false)
    private Integer qty;

    @Column(nullable = false)
    private LocalDateTime lastUpdate;

    @Column(nullable = false)
    private Double purchasePrice;

    @Column(nullable = false)
    private Double originalPrice;

    @Column(nullable = false)
    private Double sellingPrice;

    @Column(nullable = false)
    private Double discount;


    @ManyToOne
    @JoinColumn(name = "itemcat_id",nullable = false)

    private ItemCategoryEntity itemCategoryEntity;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "itemEntity",targetEntity = OrderItemsEntity.class,cascade = CascadeType.ALL)
    private Set<OrderItemsEntity> orderItemsEntities = new HashSet<>();
    
    


    
}
