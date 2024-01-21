package com.ijse.bookShop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.bookShop.dto.AdjustabaleBillDto;
import com.ijse.bookShop.entity.AdjustableBillEntity;
@Service

public interface AdjustableBillService {

    List<AdjustableBillEntity> getAll() throws Exception;
    AdjustableBillEntity create(AdjustabaleBillDto adjustabaleBillDto) throws Exception;
    AdjustableBillEntity update(Long id,AdjustabaleBillDto adjustabaleBillDto) throws Exception;

    
}
