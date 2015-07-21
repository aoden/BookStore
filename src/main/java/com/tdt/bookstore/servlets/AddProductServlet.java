package com.tdt.bookstore.servlets;

import com.tdt.bookstore.beans.Product;
import com.tdt.bookstore.service.ProductService;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add_product")
@MultipartConfig
public class AddProductServlet extends BaseServlet {

    protected ProductService productService = new ProductService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getSession().getAttribute("admin") == null) {

            resp.sendRedirect("admin");
        }
        try {
            String isbn = req.getParameter("isbn");
            String author = req.getParameter("author");
            Double price = Double.parseDouble(req.getParameter("price"));
            String description = req.getParameter("description");
            String name = req.getParameter("name");

            Product product = new Product();
            product.setName(name);
            product.setAuthor(author);
            product.setDescription(description);
            product.setUnitPrice(price);
            product.setIsbn(isbn);
            product.setImage(IOUtils.toByteArray(req.getPart("file").getInputStream()));

            productService.save(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("admin");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/add_product.jsp").forward(req, resp);
    }
}
