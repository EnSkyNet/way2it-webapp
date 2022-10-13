package com.way2it.yk.web.dao;

import com.way2it.yk.web.config.HibernateSessionConfiguration;
import com.way2it.yk.web.entity.BuyerEntity;
import com.way2it.yk.web.entity.SalerEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class SalerDaoImpl implements SalerDao{
    private static SessionFactory sessionFactory = HibernateSessionConfiguration.getSessionFactory();

    @Override
    public List<SalerEntity> getAllSalers() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT saler FROM SalerEntity saler ORDER BY id", SalerEntity.class).getResultList();
        }
    }

    @Override
    public Optional<SalerEntity> getSalerById(Integer Id) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT saler FROM SalerEntity saler  WHERE saler.id =: salerId", SalerEntity.class)
                    .setParameter("salerId", Id)
                    .getResultList()
                    .stream()
                    .findFirst();
        }
    }

    @Override
    public void saveSaler(SalerEntity salerEntity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(salerEntity);
            transaction.commit();
        }
    }

    @Override
    public void deleteSaler(SalerEntity salerEntity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(salerEntity);
            transaction.commit();
        }
    }
}
