package com.tdt.bookstore.servlets;

import com.tdt.bookstore.beans.Order;
import com.tdt.bookstore.beans.OrderDetail;
import com.tdt.bookstore.beans.ShoppingCart;
import com.tdt.bookstore.service.OrderDetailService;
import com.tdt.bookstore.service.OrderService;
import com.tdt.bookstore.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/checkout")
public class CheckoutServlet extends BaseServlet {

    private ProductService productService = new ProductService();
    private OrderService orderService = new OrderService();
    private OrderDetailService orderDetailService = new OrderDetailService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        try {
            Order order = new Order();
            order.setAddress(address);
            order.setPhone(phone);
            order.setDate(new Date());
            order.setTotal(0.0);
            orderService.save(order);
            ShoppingCart cart = (ShoppingCart) req.getSession().getAttribute("cart");

            if (cart != null) {

                for (Integer id : cart.getItems().keySet()) {

                    OrderDetail orderDetail = new OrderDetail();
                    orderDetail.setProduct(productService.find(id));
                    orderDetail.setOrder(order);
                    order.getOrderDetails().add(orderDetail);
                    orderDetail.setNumber(1);
                    Double total = order.getTotal();
                    if (total != null) {

                        order.setTotal(total + orderDetail.getProduct().getUnitPrice());
                    } else {

                        order.setTotal(orderDetail.getProduct().getUnitPrice());
                    }
                    orderDetailService.save(orderDetail);
                }
            }
            cart.clearCart();
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("checkout");
            return;
        }
        resp.sendRedirect("index");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/checkout.jsp").forward(req, resp);
    }
}
