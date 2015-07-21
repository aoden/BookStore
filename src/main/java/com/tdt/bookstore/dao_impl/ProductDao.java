package com.tdt.bookstore.dao_impl;


import com.tdt.bookstore.beans.Product;
import com.tdt.bookstore.dao.AbstractDao;
import com.tdt.bookstore.dao.PagingDao;
import org.hibernate.SessionFactory;

public class ProductDao extends AbstractDao<Product, Integer> implements PagingDao<Product, Integer> {


    @Override
    public Class getEntityClass() {
        return Product.class;
    }
}
