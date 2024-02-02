package com.ijse.bookShop.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ijse.bookShop.dto.ItemCategoryDto;
import com.ijse.bookShop.entity.ItemCategoryEntity;
import com.ijse.bookShop.service.ItemCategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@CrossOrigin(origins = "*") 

public class ItemCategoryController {
    @Autowired
    private ItemCategoryService itemCategoryService;

    @PostMapping("/admin/category")
    public ResponseEntity<?> createCategory(@RequestBody ItemCategoryDto itemCategoryDto) {
        try {
            return ResponseEntity.ok().body(itemCategoryService.createCategory(itemCategoryDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        
        
    }

    @GetMapping("/auth/category")
    public ResponseEntity<?> getAllCategory() throws Exception {
        return ResponseEntity.ok().body(itemCategoryService.getAllCategories());
    }

    @PutMapping("/admin/catgory/{id}/update")
    public ResponseEntity<?> updateItemCategory(@PathVariable Long id, @RequestBody ItemCategoryDto itemCategoryDto) {
        
        try {
            return ResponseEntity.ok().body(itemCategoryService.updateCategory(id, itemCategoryDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        
    }

    @GetMapping("/user/category/{id}")
    public ResponseEntity<?> findCategoryById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok().body(itemCategoryService.findCategoryById(id));
    }
    
    
    
    
}
