package com.tdt.bookstore.servlets;

import com.tdt.bookstore.beans.ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/remove")
public class RemoveItemServlet extends BaseServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Integer id = Integer.parseInt(req.getParameter("id"));
            ShoppingCart cart = (ShoppingCart) req.getSession().getAttribute("cart");
            cart.delete(id);
        } catch (Exception e) {
            e.printStackTrace();

        }

        resp.sendRedirect("order");
    }
}
