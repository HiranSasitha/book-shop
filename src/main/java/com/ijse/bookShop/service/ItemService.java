package com.ijse.bookShop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.bookShop.dto.ItemDto;
import com.ijse.bookShop.entity.ItemEntity;

@Service

public interface ItemService {
     List<ItemEntity> getAllItem() throws Exception;
    ItemEntity findItemById(Long id) throws Exception;
    ItemEntity createItem(ItemDto itemDto) throws Exception;
    ItemEntity updateItem(Long id,ItemDto itemDto) throws Exception;
    List<ItemEntity> getItemByCategory(Long id) throws Exception;
    void deletItem(Long id) throws Exception;
}
