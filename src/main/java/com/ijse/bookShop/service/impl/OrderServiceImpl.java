package com.ijse.bookShop.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.ijse.bookShop.dto.OrderDto;
import com.ijse.bookShop.dto.OrderItemDto;
import com.ijse.bookShop.entity.AdjustableBillEntity;
import com.ijse.bookShop.entity.ItemEntity;
import com.ijse.bookShop.entity.OrderEntity;
import com.ijse.bookShop.entity.OrderItemsEntity;
import com.ijse.bookShop.entity.UserEntity;
import com.ijse.bookShop.repository.AdjustbaleBillRepository;
import com.ijse.bookShop.repository.ItemRepository;
import com.ijse.bookShop.repository.OrderItemRepository;
import com.ijse.bookShop.repository.OrderRepository;
import com.ijse.bookShop.repository.UserRepository;
import com.ijse.bookShop.service.OrderService;


@Service

public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private AdjustbaleBillRepository adjustbaleBillRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    

    @Override
    public List<OrderEntity> getAllOrder() throws Exception {

        return orderRepository.findAll();
    }

    @Override
    public OrderEntity getOrderById(Long id) throws Exception {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public List< OrderItemsEntity> createOrders(OrderDto orderDto) throws Exception {
        List<OrderItemDto> orderItemDtos = orderDto.getOrderItemDtos();
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderTime(LocalDateTime.now());
        orderEntity.setTotal(0.0);
        

        for (OrderItemDto orderItemDto : orderItemDtos) {
            ItemEntity itemEntity = itemRepository.findById(orderItemDto.getItemId()).orElse(null);
            // Check if the items exists and have sufficient quantity
            // Update orders total and reduce item qty
            if(itemEntity != null && itemEntity.getQty()>0){
                orderEntity.setTotal(orderEntity.getTotal()+(itemEntity.getSellingPrice()*orderItemDto.getQty()));
                itemEntity.setQty(itemEntity.getQty()-orderItemDto.getQty());
                // Save  updated items
                itemRepository.save(itemEntity);
               
            }else{
                throw new Exception("Invalid items or insufficient quantity");
        }
            }
        

         AdjustableBillEntity adjustableBillEntity = adjustbaleBillRepository.findById((long) 1).orElse(null);

             if (adjustableBillEntity != null){
                            //check discount validation
                    if (adjustableBillEntity.getUpToAmount() < orderEntity.getTotal()){
                       Double discount = ((adjustableBillEntity.getDiscount()*orderEntity.getTotal())/100);
                            //check discount with max discount
                      if(adjustableBillEntity.getMaxDiscountPrice()<discount){
                             orderEntity.setTotal(orderEntity.getTotal()-adjustableBillEntity.getMaxDiscountPrice());
                       }else{
                           orderEntity.setTotal(orderEntity.getTotal()-discount);
                       }
                       //set discount
                        orderEntity.setDiscount(adjustableBillEntity.getDiscount());
                       

                   }else{
                        orderEntity.setDiscount(0.0);
                  }}
                                

                     UserEntity userEntity = userRepository.findById(orderDto.getUserId()).orElse(null);

                   if (userEntity != null){
                        orderEntity.setUserEntity(userEntity);
                        orderEntity.setTax(adjustableBillEntity.getTax());
                        // save order
                          orderRepository.save(orderEntity);

                    }else{
                        throw new Exception("Invalid user");
                }

                   

                   // Long orderId = orderRepository.findMaxId();
                    List<OrderItemsEntity> orderItemsEntities = new ArrayList<>();
                    
                    for (OrderItemDto orderItemDto : orderItemDtos) {
                        ItemEntity itemEntity = itemRepository.findById(orderItemDto.getItemId()).orElse(null);
                        OrderItemsEntity orderItemsEntity = new OrderItemsEntity();
                        if(itemEntity != null){
                        orderItemsEntity.setDiscount(itemEntity.getDiscount());
                        orderItemsEntity.setQty(orderItemDto.getQty());
                        orderItemsEntity.setItemEntity(itemEntity);
                       // orderEntity.setId(orderId);
                        orderItemsEntity.setOrderEntity(orderEntity);
                        orderItemsEntities.add(orderItemsEntity);
                        //save orderItems
                        orderItemRepository.save(orderItemsEntity);
                        
                        }
                        
                    }

                    
                    return orderItemsEntities;
                    

                    
            
            }
           
        }

       
    
    

