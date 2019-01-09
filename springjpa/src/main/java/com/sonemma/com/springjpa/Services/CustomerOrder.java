package com.sonemma.com.springjpa.Services;

import org.hibernate.annotations.JoinFormula;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
public class CustomerOrder {

    @Id
    @GeneratedValue //auto increment
    Integer oderId;
    private String orderNumber;
    private String oderDate;
    private String shippedDate;
    private Integer productId;
    private Integer customer_id;

    @ManyToOne(cascade = {CascadeType.ALL}) //adding foreign key relationship . this line automatically add a product to an oder when order are being created
    @JoinColumn(name="productId", referencedColumnName="id",insertable = false, updatable = false)
    private Product product;


    @ManyToOne(cascade = {CascadeType.ALL}) //adding foreign key relationship . this line automatically add a product to an oder when order are being created
    @JoinColumn(name="customer_id", referencedColumnName="cid",insertable = false, updatable = false)
    private Customers customer;

    public CustomerOrder(){

    }

    public CustomerOrder(String orderNumber, String oderDate, String shippedDate, Integer productId, Integer customer_id, Product product, Customers customer) {
        this.orderNumber = orderNumber;
        this.oderDate = oderDate;
        this.shippedDate = shippedDate;
        this.productId = productId;
        this.customer_id = customer_id;
        this.product = product;
        this.customer = customer;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }


    public String getOderDate() {
        return oderDate;
    }

    public void setOderDate(String oderDate) {
        this.oderDate = oderDate;
    }

    public String getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(String shippedDate) {
        this.shippedDate = shippedDate;
    }
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public Integer getOderId(){
        return oderId;
    }
}
