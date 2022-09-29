package com.way2it.yk.web.servlet;

import com.way2it.yk.web.dao.BuyerDaoMTM;
import com.way2it.yk.web.dao.BuyerDaoMTMImpl;
import com.way2it.yk.web.dto.BuyerDto;
import com.way2it.yk.web.entity.BuyerEntityMTM;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/serviceShop")
public class ShopServlet extends HttpServlet {
    private BuyerDaoMTM buyerDaoMTM = new BuyerDaoMTMImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BuyerDto> buyerDtos = buyerDaoMTM.getAllBuyers().stream()
                .map(entity -> new BuyerDto(entity.getId(), entity.getName(),entity.getMoney())).toList();

        System.out.println("We get buyer list: size of list " + buyerDtos.size());

        req.setAttribute("buyers", buyerDtos);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        String name = req.getParameter("name");
        Integer money = Integer.valueOf(req.getParameter("money"));
        BuyerEntityMTM buyerEntityMTM = BuyerEntityMTM.builder()
                .name(name)
                .money(money)
                .build();

        buyerDaoMTM.saveBuyer(buyerEntityMTM);
        List<BuyerDto> buyerDtos = buyerDaoMTM.getAllBuyers().stream()
                .map(entity -> new BuyerDto(entity.getId(), entity.getName(),entity.getMoney())).toList();

        System.out.println("We add new buyer: " + name + " and the amount: " + money);

        req.setAttribute("buyers", buyerDtos);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/");
        requestDispatcher.forward(req, resp);
    }
}
