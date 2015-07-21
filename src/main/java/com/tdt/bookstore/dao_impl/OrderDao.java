package com.tdt.bookstore.dao_impl;


import com.tdt.bookstore.beans.Order;
import com.tdt.bookstore.dao.AbstractDao;
import com.tdt.bookstore.dao.PagingDao;

public class OrderDao extends AbstractDao<Order, Integer> implements PagingDao<Order, Integer> {
    @Override
    public Class<Order> getEntityClass() {
        return Order.class;
    }
}
