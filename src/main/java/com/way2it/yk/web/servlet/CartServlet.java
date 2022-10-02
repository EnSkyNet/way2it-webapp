package com.way2it.yk.web.servlet;

import com.way2it.yk.web.dao.CartDao;
import com.way2it.yk.web.dao.CartDaoImpl;
import com.way2it.yk.web.dto.CartDto;
import com.way2it.yk.web.entity.BuyerEntity;
import com.way2it.yk.web.entity.CartEntity;
import com.way2it.yk.web.entity.ProductEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/serviceCart")
public class CartServlet extends HttpServlet {
    private CartDao cartDao = new CartDaoImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CartDto> cartDtos = cartDao.getAllCarts().stream()
                .map(entity -> new CartDto(entity.getId(), entity.getShop(), entity.getBuyerEntity().getId()
                        , entity.getProductEntity().getId(), entity.getProduct_quantity())).toList();

        System.out.println("We get cart list: size of list " + cartDtos.size());

        req.setAttribute("carts", cartDtos);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        String shop = req.getParameter("shop");
        Integer productQuantity = Integer.valueOf(req.getParameter("productQuantity"));
        Integer productId = Integer.valueOf(req.getParameter("productId"));
        Integer buyerId = Integer.valueOf(req.getParameter("buyerId"));

        CartEntity cartEntity = CartEntity.builder()
                .shop(shop)
                .buyerEntity(BuyerEntity.builder().id(buyerId).build())
                .productEntity(ProductEntity.builder().id(productId).build())
                .product_quantity(productQuantity)
                .build();

        cartDao.saveCart(cartEntity);
        List<CartDto> cartDtos = cartDao.getAllCarts().stream()
                .map(entity -> new CartDto(entity.getId(), entity.getShop(), entity.getBuyerEntity().getId()
                        , entity.getProductEntity().getId(), entity.getProduct_quantity())).toList();

        //System.out.println("We add new cart: " + name + " and the amount: " + money);

        req.setAttribute("carts", cartDtos);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/");
        requestDispatcher.forward(req, resp);
    }
}
