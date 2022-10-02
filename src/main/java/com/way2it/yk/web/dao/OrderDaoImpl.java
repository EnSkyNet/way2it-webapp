package com.way2it.yk.web.dao;


import com.way2it.yk.web.config.HibernateSessionConfiguration;
import com.way2it.yk.web.entity.OrderEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class OrderDaoImpl implements OrderDao {
    public static final Logger logger = LogManager.getLogger(Logger.class);
    private static SessionFactory sessionFactory = HibernateSessionConfiguration.getSessionFactory();

    @Override
    public void deleteOrder(OrderEntity orderEntity) {
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.delete(orderEntity);
            transaction.commit();
        }
    }

    @Override
    public void saveOrder(OrderEntity orderEntity) {
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            //logger.info(orderEntity);
            session.save(orderEntity);
            transaction.commit();
        }
    }

    @Override
    public Optional<OrderEntity> findById(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT orders FROM OrderEntity orders WHERE orders.id =: ordersId" , OrderEntity.class)
                    .setParameter("ordersId", id)
                    .getResultList()
                    .stream()
                    .findFirst();
        }
    }

    @Override
    public List<OrderEntity> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT orders FROM OrderEntity orders", OrderEntity.class).getResultList();
        }
    }
}
