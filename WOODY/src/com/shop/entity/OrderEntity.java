package com.shop.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by LalinPethiyagoda on 21/07/2015.
 */
@Entity
@Table(name = "order", schema = "public", catalog = "Shop")
public class OrderEntity {
    private Integer orderid;
    private Date orderdate;
    private String collectionby;
    private CustomerEntity customerByCustomerid;
    private Collection<OrderitemEntity> orderitemsByOrderid;

    @Id
    @Column(name = "orderid")
    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    @Basic
    @Column(name = "orderdate")
    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    @Basic
    @Column(name = "collectionby")
    public String getCollectionby() {
        return collectionby;
    }

    public void setCollectionby(String collectionby) {
        this.collectionby = collectionby;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity that = (OrderEntity) o;

        if (orderid != null ? !orderid.equals(that.orderid) : that.orderid != null) return false;
        if (orderdate != null ? !orderdate.equals(that.orderdate) : that.orderdate != null) return false;
        if (collectionby != null ? !collectionby.equals(that.collectionby) : that.collectionby != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderid != null ? orderid.hashCode() : 0;
        result = 31 * result + (orderdate != null ? orderdate.hashCode() : 0);
        result = 31 * result + (collectionby != null ? collectionby.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "customerid", referencedColumnName = "customerid")
    public CustomerEntity getCustomerByCustomerid() {
        return customerByCustomerid;
    }

    public void setCustomerByCustomerid(CustomerEntity customerByCustomerid) {
        this.customerByCustomerid = customerByCustomerid;
    }

    public Collection<OrderitemEntity> getOrderitemsByOrderid() {
        return orderitemsByOrderid;
    }

    public void setOrderitemsByOrderid(Collection<OrderitemEntity> orderitemsByOrderid) {
        this.orderitemsByOrderid = orderitemsByOrderid;
    }
}
