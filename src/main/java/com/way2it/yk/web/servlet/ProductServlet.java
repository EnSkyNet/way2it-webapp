package com.way2it.yk.web.servlet;

import com.way2it.yk.web.dao.ProductDao;
import com.way2it.yk.web.dao.ProductDaoImpl;
import com.way2it.yk.web.dto.ProductDto;
import com.way2it.yk.web.entity.ProductEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/serviceProduct")
public class ProductServlet extends HttpServlet {
    private ProductDao productDao = new ProductDaoImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductDto> productDtos = productDao.getAllProducts().stream()
                .map(entity -> new ProductDto(entity.getId(), entity.getName(),entity.getPrice())).toList();

        System.out.println("We get products list: size of list " + productDtos.size());

        req.setAttribute("products", productDtos);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        String name = req.getParameter("name");
        Integer price = Integer.valueOf(req.getParameter("price"));
        ProductEntity productEntity = ProductEntity.builder()
                .name(name)
                .price(price)
                .build();

        productDao.saveProduct(productEntity);
        List<ProductDto> productDtos = productDao.getAllProducts().stream()
                .map(entity -> new ProductDto(entity.getId(), entity.getName(),entity.getPrice())).toList();

        //System.out.println("We add new buyer: " + name + " and the amount: " + money);

        req.setAttribute("products", productDtos);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/");
        requestDispatcher.forward(req, resp);
    }
}
