package com.tdt.bookstore.beans;


import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    protected Map<Integer, Integer> items = new HashMap<Integer, Integer>();

    public void addToCart(Integer id) {

        Integer integer = items.get(id);
        if (integer != null) {

            items.put(id, integer + 1);
        } else {

            items.put(id, 1);
        }
    }

    public Integer getNumber(Integer id) {

        return items.get(id);
    }

    public void delete(Integer id) {

        items.remove(id);
    }

    public void clearCart() {

        items.clear();
    }


    public Map<Integer, Integer> getItems() {
        return items;
    }

    public void setItems(Map<Integer, Integer> items) {
        this.items = items;
    }
}
