package com.way2it.yk.web.servlet;



import com.way2it.yk.web.dao.SalerDao;
import com.way2it.yk.web.dao.SalerDaoImpl;
import com.way2it.yk.web.dto.SalerDto;
import com.way2it.yk.web.entity.SalerEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/serviceSaler")
public class SalerServlet extends HttpServlet {
    private SalerDao salerDao = new SalerDaoImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<SalerDto> salerDtos = salerDao.getAllSalers().stream()
                .map(entity -> new SalerDto(entity.getId(), entity.getName())).toList();

        System.out.println("We get salers list: size of list " + salerDtos.size());

        req.setAttribute("salers", salerDtos);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        String name = req.getParameter("name");
        SalerEntity salerEntity = SalerEntity.builder()
                .name(name)

                .build();

        salerDao.saveSaler(salerEntity);
        List<SalerDto> salerDtos = salerDao.getAllSalers().stream()
                .map(entity -> new SalerDto(entity.getId(), entity.getName())).toList();

        System.out.println("We add new buyer: " + name);

        req.setAttribute("salers", salerDtos);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/");
        requestDispatcher.forward(req, resp);
    }
}
