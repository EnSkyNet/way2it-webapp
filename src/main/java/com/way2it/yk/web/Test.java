package com.way2it.yk.web;

import com.way2it.yk.web.dao.BuyerDaoMTM;
import com.way2it.yk.web.dao.BuyerDaoMTMImpl;

public class Test {
    public static void main(String[] args) {
        BuyerDaoMTM dao = new BuyerDaoMTMImpl();
        dao.getAllBuyers().forEach(System.out::println);

    }
}
