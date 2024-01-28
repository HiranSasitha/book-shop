package com.ijse.bookShop.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.bookShop.dto.ItemDto;
import com.ijse.bookShop.entity.ItemCategoryEntity;
import com.ijse.bookShop.entity.ItemEntity;
import com.ijse.bookShop.repository.ItemCategoryRepository;
import com.ijse.bookShop.repository.ItemRepository;
import com.ijse.bookShop.service.ItemService;

@Service

public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemCategoryRepository itemCategoryRepository;

    @Override
    public List<ItemEntity> getAllItem() throws Exception{
        return itemRepository.findAll();
    }

    @Override
    public ItemEntity findItemById(Long id) throws Exception {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public ItemEntity createItem(ItemDto itemDto) throws Exception {



        ItemCategoryEntity itemCategoryEntity = itemCategoryRepository.findById(itemDto.getCategoryId()).orElse(null);

        if (itemCategoryEntity != null){
            ItemEntity itemEntity = new ItemEntity();
            itemEntity.setName(itemDto.getName());
            itemEntity.setDiscription(itemDto.getDiscription());
            itemEntity.setQty(itemDto.getQty());
            itemEntity.setPurchasePrice(itemDto.getPurchasePrice());
            itemEntity.setLastUpdate(LocalDateTime.now());
            itemEntity.setOriginalPrice(itemDto.getOriginalPrice());
            itemEntity.setDiscount(itemDto.getDiscount());
            itemEntity.setSellingPrice(itemDto.getOriginalPrice()-(itemDto.getDiscount()));
            itemEntity.setItemCategoryEntity(itemCategoryEntity);

            return itemRepository.save(itemEntity);

        }
        return null;
    }

    @Override
    public ItemEntity updateItem(Long id, ItemDto itemDto) throws Exception {
       ItemEntity itemEntity = itemRepository.findById(id).orElse(null);

       if (itemEntity != null){
        ItemCategoryEntity itemCategoryEntity = itemCategoryRepository.findById(itemDto.getCategoryId()).orElse(null);

        if (itemCategoryEntity != null){
            itemEntity.setName(itemDto.getName());
            itemEntity.setDiscription(itemDto.getDiscription());
            itemEntity.setQty(itemDto.getQty());
            itemEntity.setPurchasePrice(itemDto.getPurchasePrice());
            itemEntity.setLastUpdate(LocalDateTime.now());
            itemEntity.setOriginalPrice(itemDto.getOriginalPrice());
            itemEntity.setDiscount(itemDto.getDiscount());
            itemEntity.setSellingPrice(itemDto.getOriginalPrice()-(itemDto.getDiscount()));
            itemEntity.setItemCategoryEntity(itemCategoryEntity);

            return itemRepository.save(itemEntity);

       }
       return null;
    }
    return null;
}

    @Override
    public List<ItemEntity> getItemByCategory(Long id) throws Exception{

        ItemCategoryEntity itemCategoryEntity = itemCategoryRepository.findById(id).orElse(null);
        if(itemCategoryEntity != null){
            return itemRepository.findItemByCategory(itemCategoryEntity);
        }
        return null;
    }

    @Override
    public void deletItem(Long id) throws Exception{
        itemRepository.deleteById(id);

    }
    
}
