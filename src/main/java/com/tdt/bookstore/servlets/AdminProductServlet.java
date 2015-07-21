package com.tdt.bookstore.servlets;


import com.tdt.bookstore.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin")
public class AdminProductServlet extends BaseServlet {

    ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getSession().getAttribute("admin") != null) {

            req.setAttribute("products", productService.getAllProducts());
            req.getRequestDispatcher("/WEB-INF/admin.jsp").forward(req, resp);
        }
        resp.sendRedirect("login");
    }

}
