package com.way2it.yk.web.servlet;


import com.way2it.yk.web.dao.OrderDao;
import com.way2it.yk.web.dao.OrderDaoImpl;
import com.way2it.yk.web.dto.BuyerDto;
import com.way2it.yk.web.dto.OrderDto;
import com.way2it.yk.web.entity.BuyerEntity;
import com.way2it.yk.web.entity.OrderEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/serviceOrder")
public class OrderServlet extends HttpServlet {
    private OrderDao orderDao = new OrderDaoImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<OrderDto> ordersDtos = orderDao.findAll().stream()
                .map(entity -> new OrderDto(entity.getId(), entity.getTotal(),entity.getBuyer().getId())).toList();

        System.out.println("We get orders list: size of list " + ordersDtos.size());

        req.setAttribute("orders", ordersDtos);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        Integer total = Integer.valueOf(req.getParameter("total"));
        Integer buyerId = Integer.valueOf(req.getParameter("buyerId"));
        OrderEntity orderEntity = OrderEntity.builder()
                .total(total)
                .buyer(BuyerEntity.builder().id(buyerId).build())
                .build();

        orderDao.saveOrder(orderEntity);
        List<OrderDto> ordersDtos = orderDao.findAll().stream()
                .map(entity -> new OrderDto(entity.getId(), entity.getTotal(),entity.getBuyer().getId())).toList();

        //System.out.println("We add new buyer: " + name + " and the amount: " + money);

        req.setAttribute("orders", ordersDtos);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/");
        requestDispatcher.forward(req, resp);
    }
}
