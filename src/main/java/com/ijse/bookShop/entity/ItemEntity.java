package com.ijse.bookShop.entity;

import java.time.LocalDateTime;

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


    
}
