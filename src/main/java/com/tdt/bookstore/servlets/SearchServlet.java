package com.tdt.bookstore.servlets;

import com.tdt.bookstore.beans.Product;
import com.tdt.bookstore.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends BaseServlet {

    ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String key = req.getParameter("key");
        List<Product> products = productService.searchByName(key);
        req.setAttribute("products", products);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
