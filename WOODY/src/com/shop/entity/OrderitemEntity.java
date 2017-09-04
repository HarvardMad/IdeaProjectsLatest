package com.shop.entity;

import javax.persistence.*;

/**
 * Created by LalinPethiyagoda on 21/07/2015.
 */
@Entity
@Table(name = "orderitem", schema = "public", catalog = "Shop")
public class OrderitemEntity {
    private Integer orderitemid;
    private Double unitprice;
    private Integer quantitypurchased;
    private Double subtotal;
    private String size;
    private String itemcode;
    private String itemdescription;
    private OrderEntity orderByOrderid;
    private ProductEntity productByProductid;

    @Id
    @Column(name = "orderitemid")
    public Integer getOrderitemid() {
        return orderitemid;
    }

    public void setOrderitemid(Integer orderitemid) {
        this.orderitemid = orderitemid;
    }

    @Basic
    @Column(name = "unitprice")
    public Double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Double unitprice) {
        this.unitprice = unitprice;
    }

    @Basic
    @Column(name = "quantitypurchased")
    public Integer getQuantitypurchased() {
        return quantitypurchased;
    }

    public void setQuantitypurchased(Integer quantitypurchased) {
        this.quantitypurchased = quantitypurchased;
    }

    @Basic
    @Column(name = "subtotal")
    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    @Basic
    @Column(name = "size")
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Basic
    @Column(name = "itemcode")
    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    @Basic
    @Column(name = "itemdescription")
    public String getItemdescription() {
        return itemdescription;
    }

    public void setItemdescription(String itemdescription) {
        this.itemdescription = itemdescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderitemEntity that = (OrderitemEntity) o;

        if (orderitemid != null ? !orderitemid.equals(that.orderitemid) : that.orderitemid != null) return false;
        if (unitprice != null ? !unitprice.equals(that.unitprice) : that.unitprice != null) return false;
        if (quantitypurchased != null ? !quantitypurchased.equals(that.quantitypurchased) : that.quantitypurchased != null)
            return false;
        if (subtotal != null ? !subtotal.equals(that.subtotal) : that.subtotal != null) return false;
        if (size != null ? !size.equals(that.size) : that.size != null) return false;
        if (itemcode != null ? !itemcode.equals(that.itemcode) : that.itemcode != null) return false;
        if (itemdescription != null ? !itemdescription.equals(that.itemdescription) : that.itemdescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderitemid != null ? orderitemid.hashCode() : 0;
        result = 31 * result + (unitprice != null ? unitprice.hashCode() : 0);
        result = 31 * result + (quantitypurchased != null ? quantitypurchased.hashCode() : 0);
        result = 31 * result + (subtotal != null ? subtotal.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (itemcode != null ? itemcode.hashCode() : 0);
        result = 31 * result + (itemdescription != null ? itemdescription.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "orderid", referencedColumnName = "orderid")
    public OrderEntity getOrderByOrderid() {
        return orderByOrderid;
    }

    public void setOrderByOrderid(OrderEntity orderByOrderid) {
        this.orderByOrderid = orderByOrderid;
    }

    public ProductEntity getProductByProductid() {
        return productByProductid;
    }

    public void setProductByProductid(ProductEntity productByProductid) {
        this.productByProductid = productByProductid;
    }
}
