package com.way2it.yk.web.dao;



import com.way2it.yk.web.entity.CartEntity;

import java.util.List;
import java.util.Optional;

public interface CartDao {
    List<CartEntity> getAllCarts();

    Optional<CartEntity> getCartById(Integer Id);

    void saveCart(CartEntity cartEntity);
    void deleteCart(CartEntity cartEntity);

}
