package com.way2it.yk.web.dao;



import com.way2it.yk.web.entity.OrderEntityMTM;

import java.util.List;
import java.util.Optional;

public interface OrderDaoMTM {
    void deleteOrder(OrderEntityMTM orderEntityMTM);
    void saveOrder(OrderEntityMTM orderEntityMTM);
    Optional<OrderEntityMTM> findById(Integer id);
    List<OrderEntityMTM> findAll();
}
