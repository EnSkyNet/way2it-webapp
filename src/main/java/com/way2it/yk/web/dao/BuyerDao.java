package com.way2it.yk.web.dao;



import com.way2it.yk.web.entity.BuyerEntity;
import com.way2it.yk.web.entity.CartEntity;

import java.util.List;
import java.util.Optional;

public interface BuyerDao {
    List<BuyerEntity> getAllBuyers();

    Optional<BuyerEntity> getBuyerById(Integer buyerId);

    void saveBuyer(BuyerEntity buyerEntity);
    void deleteBuyer(BuyerEntity buyerEntity);

    List<CartEntity> getCartByBuyerId(Integer buyerId);
}
