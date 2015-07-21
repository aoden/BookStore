package com.tdt.bookstore.service;


import com.tdt.bookstore.beans.Order;
import com.tdt.bookstore.dao_impl.OrderDao;

public class OrderService extends AbstractService {

    private OrderDao orderDao;

    public OrderService() {
        orderDao = new OrderDao();
        orderDao.setSessionFactory(getSessionFactory());
    }

    public void save(Order order) {

        orderDao.save(order);
    }
}
