package com.way2it.yk.web.dao;


import com.way2it.yk.web.config.DatabaseConfig;
import com.way2it.yk.web.config.HibernateSessionConfiguration;
import com.way2it.yk.web.entity.BuyerEntity;
import com.way2it.yk.web.entity.CartEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BuyerDaoImpl implements BuyerDao {
    public static final Logger logger = LogManager.getLogger(Logger.class);

    private static SessionFactory sessionFactory = HibernateSessionConfiguration.getSessionFactory();
    private static EntityManager entityManager;

    static {
        entityManager = DatabaseConfig.getEntityManager();
    }

    @Override
    public List<BuyerEntity> getAllBuyers() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT buyer FROM BuyerEntity buyer", BuyerEntity.class).getResultList();
        }
    }

    @Override
    public void saveBuyer(BuyerEntity buyerEntity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(buyerEntity);
            transaction.commit();
        }
    }
    @Override
    public Optional<BuyerEntity> getBuyerById(Integer buyerId) {
        return entityManager.createQuery("SELECT buyer FROM BuyerEntity buyer WHERE buyer.id =: buyerId", BuyerEntity.class)
                .setParameter("buyerId", buyerId)
                .getResultList()
                .stream()
                .findFirst();
    }
     @Override
    public void deleteBuyer(BuyerEntity buyerEntity) {
         try (Session session = sessionFactory.openSession()) {
             Transaction transaction = session.beginTransaction();
             session.remove(buyerEntity);
             transaction.commit();
         }
    }

    @Override
    public List<CartEntity> getCartByBuyerId(Integer buyerId) {
        return entityManager.createQuery("SELECT buyer FROM BuyerEntity buyer JOIN buyer.cartEntityList WHERE buyer.id =: buyer_id", BuyerEntity.class)
                .setParameter("buyer_id", buyerId)
                .getResultList()
                .stream()
                .flatMap(entity->entity.getCartEntityList()
                        .stream())
                .collect(Collectors.toList());
    }
}