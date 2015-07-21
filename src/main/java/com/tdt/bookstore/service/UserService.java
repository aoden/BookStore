package com.tdt.bookstore.service;


import com.tdt.bookstore.beans.User;
import com.tdt.bookstore.dao_impl.UserDao;
import com.tdt.bookstore.util.HashUtil;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class UserService extends AbstractService {

    protected UserDao userDao;

    public UserService() {

        userDao = new UserDao(getSessionFactory());
    }

    public User login(String id, String password) throws NoSuchAlgorithmException {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        User user = (User) userDao.find("from User where id = :id", params, 0, Integer.MAX_VALUE);

        if (user!= null) {

            if (user.getPassword().equals(HashUtil.hash("MD5", password))) {

                return user;
            }
        }
        return null;
    }
}
