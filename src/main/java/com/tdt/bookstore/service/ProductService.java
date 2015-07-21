package com.tdt.bookstore.service;

import com.tdt.bookstore.beans.Product;
import com.tdt.bookstore.dao_impl.ProductDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService extends AbstractService {

    private ProductDao productDao;

    public ProductService() {
        productDao = new ProductDao();
        productDao.setSessionFactory(getSessionFactory());
    }

    public List<Product> searchByName(String name) {

        Map<String,Object> params = new HashMap<String, Object>();
        params.put("name", name);
        return productDao.findList("from Product p where p.name like concat('%', :name, '%')",
                params, 0, Integer.MAX_VALUE);
    }

    public void update(Product p) {

        productDao.update(p);
    }

    public void save(Product product) {

        productDao.save(product);
    }

    public Product find(Integer id) {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);

        return (Product) productDao.find("from Product where id=:id", params, 0, Integer.MAX_VALUE);
    }

    public List<Product> getAllProducts() {

        return productDao.findList("from Product", null, 0, Integer.MAX_VALUE);
    }
}
