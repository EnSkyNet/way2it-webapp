package com.way2it.yk.web.dao;



import com.way2it.yk.web.entity.CartEntityMTM;

import java.util.List;
import java.util.Optional;

public interface CartDaoMTM {
    List<CartEntityMTM> getAllCarts();

    Optional<CartEntityMTM> getCartById(Integer Id);

    void saveCart(CartEntityMTM cartEntityMTM);
    void deleteCart(CartEntityMTM cartEntityMTM);

}
