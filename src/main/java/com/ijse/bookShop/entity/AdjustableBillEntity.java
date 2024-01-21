package com.ijse.bookShop.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data


@Table(name = "adjusmetn_bill")

public class AdjustableBillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "discount(%)", nullable = false)
    private Double discount;

    @Column(nullable = false)
    private Double upToAmount;

    @Column(nullable = false)
    private Double MaxDiscountPrice;

    @Column(name = "tax(%)",nullable = false)
    private Double tax;

    @Column(nullable = false)
    private LocalDateTime lastUpdate;

}
