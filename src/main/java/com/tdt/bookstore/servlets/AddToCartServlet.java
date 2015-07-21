package com.tdt.bookstore.servlets;

import com.tdt.bookstore.beans.ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add_to_cart")
public class AddToCartServlet extends BaseServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ShoppingCart cart = (ShoppingCart) req.getSession().getAttribute("cart");
        if (cart == null) {

            cart = new ShoppingCart();
        }
        try{

            cart.addToCart(Integer.parseInt(req.getParameter("id")));
            req.getSession().setAttribute("cart", cart);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(500);
        }
    }
}
