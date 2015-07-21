package com.tdt.bookstore.dao_impl;


import com.tdt.bookstore.beans.OrderDetail;
import com.tdt.bookstore.dao.AbstractDao;
import com.tdt.bookstore.dao.PagingDao;
import org.hibernate.SessionFactory;

public class OrderDetailDao extends AbstractDao<OrderDetail, Integer> implements PagingDao<OrderDetail, Integer> {

    @Override
    public Class<OrderDetail> getEntityClass() {
        return OrderDetail.class;
    }
}
