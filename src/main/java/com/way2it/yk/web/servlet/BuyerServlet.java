package com.way2it.yk.web.servlet;

import com.way2it.yk.web.dao.BuyerDao;
import com.way2it.yk.web.dao.BuyerDaoImpl;
import com.way2it.yk.web.dto.BuyerDto;
import com.way2it.yk.web.entity.BuyerEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/serviceBuyer")
public class BuyerServlet extends HttpServlet {
    private BuyerDao buyerDao = new BuyerDaoImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BuyerDto> buyerDtos = buyerDao.getAllBuyers().stream()
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
        BuyerEntity buyerEntity = BuyerEntity.builder()
                .name(name)
                .money(money)
                .build();

        buyerDao.saveBuyer(buyerEntity);
        List<BuyerDto> buyerDtos = buyerDao.getAllBuyers().stream()
                .map(entity -> new BuyerDto(entity.getId(), entity.getName(),entity.getMoney())).toList();

        System.out.println("We add new buyer: " + name + " and the amount: " + money);

        req.setAttribute("buyers", buyerDtos);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/");
        requestDispatcher.forward(req, resp);
    }
}
