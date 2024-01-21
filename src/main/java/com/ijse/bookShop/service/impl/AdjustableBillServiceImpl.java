package com.ijse.bookShop.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.bookShop.dto.AdjustabaleBillDto;
import com.ijse.bookShop.entity.AdjustableBillEntity;
import com.ijse.bookShop.repository.AdjustbaleBillRepository;
import com.ijse.bookShop.service.AdjustableBillService;

@Service

public class AdjustableBillServiceImpl implements AdjustableBillService  {

    @Autowired
    private AdjustbaleBillRepository adjustbaleBillRepository;

    @Override
    public List<AdjustableBillEntity> getAll() throws Exception {
        return adjustbaleBillRepository.findAll();
    }

    @Override
    public AdjustableBillEntity create(AdjustabaleBillDto adjustabaleBillDto) throws Exception {
        AdjustableBillEntity adjustableBillEntity = new AdjustableBillEntity();
        adjustableBillEntity.setDiscount(adjustabaleBillDto.getDiscount());
        adjustableBillEntity.setMaxDiscountPrice(adjustabaleBillDto.getMaxDiscountPrice());
        adjustableBillEntity.setUpToAmount(adjustabaleBillDto.getUpToAmount());
        adjustableBillEntity.setTax(adjustabaleBillDto.getTax());
        adjustableBillEntity.setLastUpdate(LocalDateTime.now());
        
        return adjustbaleBillRepository.save(adjustableBillEntity) ;
    }

    @Override
    public AdjustableBillEntity update(Long id,AdjustabaleBillDto adjustabaleBillDto) throws Exception {

        AdjustableBillEntity adjustableBillEntity = adjustbaleBillRepository.findById(id).orElse(null);

        if (adjustableBillEntity != null) {

        adjustableBillEntity.setDiscount(adjustabaleBillDto.getDiscount());
        adjustableBillEntity.setMaxDiscountPrice(adjustabaleBillDto.getMaxDiscountPrice());
        adjustableBillEntity.setUpToAmount(adjustabaleBillDto.getUpToAmount());
        adjustableBillEntity.setTax(adjustabaleBillDto.getTax());
        adjustableBillEntity.setLastUpdate(LocalDateTime.now());
        
        return adjustbaleBillRepository.save(adjustableBillEntity) ;
            
        }
        return null;
    }
    
}
