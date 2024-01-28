package com.ijse.bookShop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.bookShop.dto.ItemCategoryDto;
import com.ijse.bookShop.entity.ItemCategoryEntity;

@Service

public interface ItemCategoryService {
    List<ItemCategoryEntity> getAllCategories() throws Exception;
    ItemCategoryEntity findCategoryById(Long id) throws Exception;
    ItemCategoryEntity createCategory(ItemCategoryDto itemCategoryDto) throws Exception;
    ItemCategoryEntity updateCategory(Long id,ItemCategoryDto itemCategoryDto) throws Exception;
    
}
