package com.tdt.bookstore.beans;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetail {

    @Id @GeneratedValue
    protected Integer id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    protected Product product;
    @ManyToOne
    @JoinColumn(name = "order_id")
    protected Order order;

    protected Integer number;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}
