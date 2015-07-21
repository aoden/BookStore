package com.tdt.bookstore.servlets;

import com.tdt.bookstore.beans.Product;
import com.tdt.bookstore.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet("/image")
public class ImageServlet extends BaseServlet {

    ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        byte[] image = null;
        try {

            Integer id = Integer.parseInt(req.getParameter("id"));
            Product product = productService.find(id);
            image = product.getImage();
        } catch (Exception e) {

        }
        resp.setContentType("image/jpeg");
        InputStream in = new ByteArrayInputStream(image);
        OutputStream out = resp.getOutputStream();

        // Copy the contents of the file to the output stream
        byte[] buf = new byte[1024];
        int count = 0;
        while ((count = in.read(buf)) >= 0) {
            out.write(buf, 0, count);
        }
        out.close();
        in.close();
    }
}
