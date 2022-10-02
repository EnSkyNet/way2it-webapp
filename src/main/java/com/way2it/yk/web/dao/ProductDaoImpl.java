package com.way2it.yk.web.dao;

import com.way2it.yk.web.config.DatabaseConfig;
import com.way2it.yk.web.entity.ProductEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDaoImpl implements ProductDao {
    private static EntityManager entityManager;

    static {
        entityManager = DatabaseConfig.getEntityManager();
    }


    @Override
    public List<ProductEntity> getAllProducts() {
        List<ProductEntity> productEntity = new ArrayList<>();
        return entityManager.createQuery("SELECT product FROM ProductEntity product ", ProductEntity.class).getResultList();
    }

    @Override
    public Optional<ProductEntity> getProductById(Integer productId) {
        return entityManager.createQuery("SELECT product FROM ProductEntity product WHERE product.id =: productId", ProductEntity.class)
                .setParameter("productId", productId)
                .getResultList()
                .stream()
                .findFirst();
    }

    @Override
    public void saveProduct(ProductEntity productEntity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(productEntity);
        transaction.commit();
    }

    @Override
    public void deleteProduct(ProductEntity productEntity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(productEntity);
        transaction.commit();

    }
}
