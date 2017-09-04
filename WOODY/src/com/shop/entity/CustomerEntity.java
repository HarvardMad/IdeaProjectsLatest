package com.shop.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by LalinPethiyagoda on 21/07/2015.
 */
@Entity
@Table(name = "customer", schema = "public", catalog = "Shop")
public class CustomerEntity {
    private Integer customerid;
    private String mobilephone;
    private String name;
    private String telephone;
    private String email;
    private String password;
    private CustomerEntity customerByCustomerid;
    private CustomerEntity customerByCustomerid_0;
    private Collection<OrderEntity> ordersByCustomerid;

    @Id
    @Column(name = "customerid")
    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    @Basic
    @Column(name = "mobilephone")
    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "telephone")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerEntity that = (CustomerEntity) o;

        if (customerid != null ? !customerid.equals(that.customerid) : that.customerid != null) return false;
        if (mobilephone != null ? !mobilephone.equals(that.mobilephone) : that.mobilephone != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (telephone != null ? !telephone.equals(that.telephone) : that.telephone != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerid != null ? customerid.hashCode() : 0;
        result = 31 * result + (mobilephone != null ? mobilephone.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "customerid", referencedColumnName = "customerid", nullable = false)
    public CustomerEntity getCustomerByCustomerid() {
        return customerByCustomerid;
    }

    public void setCustomerByCustomerid(CustomerEntity customerByCustomerid) {
        this.customerByCustomerid = customerByCustomerid;
    }

    @OneToOne(mappedBy = "customerByCustomerid")
    public CustomerEntity getCustomerByCustomerid_0() {
        return customerByCustomerid_0;
    }

    public void setCustomerByCustomerid_0(CustomerEntity customerByCustomerid_0) {
        this.customerByCustomerid_0 = customerByCustomerid_0;
    }

    public Collection<OrderEntity> getOrdersByCustomerid() {
        return ordersByCustomerid;
    }

    public void setOrdersByCustomerid(Collection<OrderEntity> ordersByCustomerid) {
        this.ordersByCustomerid = ordersByCustomerid;
    }
}
