package com.way2it.yk.web.dao;



import com.way2it.yk.web.entity.OrderEntity;

import java.util.List;
import java.util.Optional;

public interface OrderDao {
    void deleteOrder(OrderEntity orderEntity);
    void saveOrder(OrderEntity orderEntity);
    Optional<OrderEntity> findById(Integer id);
    List<OrderEntity> findAll();
}
