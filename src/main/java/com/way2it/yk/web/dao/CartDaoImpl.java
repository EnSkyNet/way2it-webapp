package com.way2it.yk.web.dao;



import com.way2it.yk.web.config.DatabaseConfig;
import com.way2it.yk.web.entity.CartEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CartDaoImpl implements CartDao {
    private static EntityManager entityManager;

    static {
        entityManager = DatabaseConfig.getEntityManager();
    }
    @Override
    public List<CartEntity> getAllCarts() {
        List<CartEntity> cartEntities = new ArrayList<>();
        return entityManager.createQuery("SELECT cart FROM CartEntity cart ", CartEntity.class).getResultList();
    }

    @Override
    public Optional<CartEntity> getCartById(Integer cartId) {
        return entityManager.createQuery("SELECT cart FROM CartEntity cart WHERE cart.id =: cartId", CartEntity.class)
                .setParameter("cartId", cartId)
                .getResultList()
                .stream()
                .findFirst();
    }

    @Override
    public void saveCart(CartEntity cartEntity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(cartEntity);
        transaction.commit();
    }

    @Override
    public void deleteCart(CartEntity cartEntity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(cartEntity);
        transaction.commit();
    }
}