package com.ijse.bookShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.bookShop.dto.ItemDto;
import com.ijse.bookShop.service.ItemService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@CrossOrigin(origins = "*") 

public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/admin/item")
    public ResponseEntity<?> saveItem(@RequestBody ItemDto itemDto) {
        
        try {
            return ResponseEntity.ok().body(itemService.createItem(itemDto));
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
        
    }

    @GetMapping("/auth/item")
    public ResponseEntity<?> getAllItem() throws Exception {
        return ResponseEntity.ok().body(itemService.getAllItem());
    }

    @PutMapping("/admin/item/{id}/update")
    public ResponseEntity<?> updateItem(@PathVariable Long id, @RequestBody ItemDto itemDto) {
        try {
            return ResponseEntity.ok().body(itemService.updateItem(id, itemDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/user/categories/{id}/items")
    public ResponseEntity<?> getItemByCategory(@PathVariable Long id)  {
        try {
            return ResponseEntity.ok().body(itemService.getItemByCategory(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/admin/item/{id}/delete")
    public ResponseEntity<?> deleteItem(@PathVariable Long id) throws Exception{
        itemService.deletItem(id);

        return ResponseEntity.ok().body("successfull delete");
    }

    @GetMapping("/user/item/{id}")
    public ResponseEntity<?> getItemById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok().body(itemService.findItemById(id));
    }
    
    
    
    
    
}
