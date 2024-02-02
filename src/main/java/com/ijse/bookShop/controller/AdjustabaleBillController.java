package com.ijse.bookShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.bookShop.dto.AdjustabaleBillDto;
import com.ijse.bookShop.service.AdjustableBillService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@CrossOrigin(origins = "*") 
public class AdjustabaleBillController {

    @Autowired
    private AdjustableBillService adjustableBillService;

    @PostMapping("/admin/adjusbill")
    public ResponseEntity<?> create(@RequestBody AdjustabaleBillDto adjustabaleBillDto) {
        try {
            return ResponseEntity.ok().body(adjustableBillService.create(adjustabaleBillDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/auth/adjusbill")
    public ResponseEntity<?> getAll() throws Exception {
        return ResponseEntity.ok().body(adjustableBillService.getAll());
    }

    @PutMapping("/admin/adjusbill/{id}/update")
    public ResponseEntity<?> putMethodName(@PathVariable Long id, @RequestBody AdjustabaleBillDto adjustabaleBillDto) {
        try {
            return ResponseEntity.ok().body(adjustableBillService.update(id, adjustabaleBillDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    

    
}
