package com.tdt.bookstore.servlets;


import com.tdt.bookstore.beans.Product;
import com.tdt.bookstore.beans.ShoppingCart;
import com.tdt.bookstore.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/order")
public class OrderServlet extends BaseServlet {

    ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ShoppingCart cart = (ShoppingCart) req.getSession().getAttribute("cart");
        List<Product> products = new ArrayList<Product>();
        if (cart != null) {

            for (Integer id: cart.getItems().keySet()) {

                products.add(productService.find(id));
            }
        }
        req.setAttribute("products", products);
        req.getRequestDispatcher("order.jsp").forward(req, resp);
    }
}
