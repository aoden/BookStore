package com.tdt.bookstore.dao_impl;


import com.tdt.bookstore.beans.User;
import com.tdt.bookstore.dao.AbstractDao;
import com.tdt.bookstore.dao.PagingDao;
import org.hibernate.SessionFactory;

public class UserDao extends AbstractDao<User, String> implements PagingDao<User, String> {
    public UserDao(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }
}
