package com.tdt.bookstore.servlets;

import com.tdt.bookstore.beans.User;
import com.tdt.bookstore.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet("/login")
public class AdminLoginServlet extends BaseServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String password = req.getParameter("password");

        try {
            User user = userService.login(id, password);
            if (user != null) {

                req.getSession().setAttribute("admin", user);
                resp.sendRedirect("admin");
            } else {

                resp.sendRedirect("login");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            resp.sendRedirect("login");
        }
    }
}
