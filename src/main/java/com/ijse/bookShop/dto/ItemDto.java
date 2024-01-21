package com.ijse.bookShop.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import lombok.Data;
@Data

public class ItemDto {

    private Long categoryId;

    private String name;

    private String discription;

    private Integer qty;

    private Double purchasePrice;

    private Double originalPrice;

    private Double discount;
}
