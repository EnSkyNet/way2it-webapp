package com.way2it.yk.web;

import com.way2it.yk.web.dao.BuyerDao;
import com.way2it.yk.web.dao.BuyerDaoImpl;

public class Test {
    public static void main(String[] args) {
        BuyerDao dao = new BuyerDaoImpl();
        dao.getAllBuyers().forEach(System.out::println);

    }
}
