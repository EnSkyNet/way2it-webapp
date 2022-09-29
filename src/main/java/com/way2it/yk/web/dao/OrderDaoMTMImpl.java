package com.way2it.yk.web.dao;


import com.way2it.yk.web.config.HibernateSessionConfiguration;
import com.way2it.yk.web.entity.OrderEntityMTM;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class OrderDaoMTMImpl implements OrderDaoMTM {
    public static final Logger logger = LogManager.getLogger(Logger.class);
    private static SessionFactory sessionFactory = HibernateSessionConfiguration.getSessionFactory();

    @Override
    public void deleteOrder(OrderEntityMTM orderEntityMTM) {
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.delete(orderEntityMTM);
            transaction.commit();
        }
    }

    @Override
    public void saveOrder(OrderEntityMTM orderEntityMTM) {
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            logger.info(orderEntityMTM);
            session.save(orderEntityMTM);
            transaction.commit();
        }
    }

    @Override
    public Optional<OrderEntityMTM> findById(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT orders FROM OrderEntityMTM orders WHERE orders.id =: ordersId" , OrderEntityMTM.class)
                    .setParameter("ordersId", id)
                    .getResultList()
                    .stream()
                    .findFirst();
        }
    }

    @Override
    public List<OrderEntityMTM> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT orders FROM OrderEntityOTO orders", OrderEntityMTM.class).getResultList();
        }
    }
}
