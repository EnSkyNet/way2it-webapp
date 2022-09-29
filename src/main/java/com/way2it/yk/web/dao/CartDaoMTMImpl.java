package com.way2it.yk.web.dao;



import com.way2it.yk.web.config.DatabaseConfig;
import com.way2it.yk.web.entity.CartEntityMTM;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CartDaoMTMImpl implements CartDaoMTM {
    private static EntityManager entityManager;

    static {
        entityManager = DatabaseConfig.getEntityManager();
    }
    @Override
    public List<CartEntityMTM> getAllCarts() {
        List<CartEntityMTM> cartEntities = new ArrayList<>();
        return entityManager.createQuery("SELECT cart FROM CartEntityMTM cart ", CartEntityMTM.class).getResultList();
    }

    @Override
    public Optional<CartEntityMTM> getCartById(Integer cartId) {
        return entityManager.createQuery("SELECT cart FROM CartEntityMTM cart WHERE cart.id =: cartId", CartEntityMTM.class)
                .setParameter("cartId", cartId)
                .getResultList()
                .stream()
                .findFirst();
    }

    @Override
    public void saveCart(CartEntityMTM cartEntityMTM) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(cartEntityMTM);
        transaction.commit();
    }

    @Override
    public void deleteCart(CartEntityMTM cartEntityMTM) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(cartEntityMTM);
        transaction.commit();
    }
}