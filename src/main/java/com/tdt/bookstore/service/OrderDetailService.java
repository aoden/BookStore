package com.tdt.bookstore.service;

import com.tdt.bookstore.beans.OrderDetail;
import com.tdt.bookstore.dao_impl.OrderDetailDao;
import org.hibernate.SessionFactory;

public class OrderDetailService extends AbstractService{

    OrderDetailDao orderDetailDao;

    public OrderDetailService() {

        orderDetailDao = new OrderDetailDao();
        orderDetailDao.setSessionFactory(getSessionFactory());
    }

    public void save(OrderDetail orderDetail) {

        orderDetailDao.save(orderDetail);
    }
}
