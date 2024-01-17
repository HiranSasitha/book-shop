package com.ijse.bookShop.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "item_category")
@Data

public class ItemCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;

    @JsonIgnore

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "itemCategoryEntity",targetEntity = ItemEntity.class, cascade = CascadeType.ALL)

    private Set<ItemEntity> itemEntities = new HashSet<>();
}
