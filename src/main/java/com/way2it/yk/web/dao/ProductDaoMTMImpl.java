package com.way2it.yk.web.dao;

import com.way2it.yk.web.config.DatabaseConfig;
import com.way2it.yk.web.entity.ProductEntityMTM;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDaoMTMImpl implements ProductDaoMTM {
    private static EntityManager entityManager;

    static {
        entityManager = DatabaseConfig.getEntityManager();
    }


    @Override
    public List<ProductEntityMTM> getAllProducts() {
        List<ProductEntityMTM> productEntityMTM = new ArrayList<>();
        return entityManager.createQuery("SELECT product FROM ProductEntityMTM product ", ProductEntityMTM.class).getResultList();
    }

    @Override
    public Optional<ProductEntityMTM> getProductById(Integer productId) {
        return entityManager.createQuery("SELECT product FROM ProductEntityMTM product WHERE product.id =: productId", ProductEntityMTM.class)
                .setParameter("productId", productId)
                .getResultList()
                .stream()
                .findFirst();
    }

    @Override
    public void saveProduct(ProductEntityMTM productEntityMTM) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(productEntityMTM);
        transaction.commit();
    }

    @Override
    public void deleteProduct(ProductEntityMTM productEntityMTM) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(productEntityMTM);
        transaction.commit();

    }
}
