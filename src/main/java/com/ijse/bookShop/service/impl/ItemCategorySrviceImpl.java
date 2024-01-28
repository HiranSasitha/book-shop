package com.ijse.bookShop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.bookShop.dto.ItemCategoryDto;
import com.ijse.bookShop.entity.ItemCategoryEntity;
import com.ijse.bookShop.repository.ItemCategoryRepository;
import com.ijse.bookShop.service.ItemCategoryService;
@Service

public class ItemCategorySrviceImpl implements ItemCategoryService {

    @Autowired
    private ItemCategoryRepository itemCategoryRepository;

    @Override
    public List<ItemCategoryEntity> getAllCategories() throws Exception {
        return itemCategoryRepository.findAll();
    }

    @Override
    public ItemCategoryEntity findCategoryById(Long id) throws Exception {
       return itemCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public ItemCategoryEntity createCategory(ItemCategoryDto itemCategoryDto) throws Exception {
        ItemCategoryEntity entity = new ItemCategoryEntity();
        entity.setName(itemCategoryDto.getName());
       return itemCategoryRepository.save(entity);
    }

    @Override
    public ItemCategoryEntity updateCategory(Long id, ItemCategoryDto itemCategoryDto) throws Exception {
        ItemCategoryEntity itemCategoryEntity = itemCategoryRepository.findById(id).orElse(null);

        if(itemCategoryEntity != null){
            itemCategoryEntity.setName(itemCategoryDto.getName());
            return itemCategoryRepository.save(itemCategoryEntity);
        }
            
        return null;
    }
    
}
