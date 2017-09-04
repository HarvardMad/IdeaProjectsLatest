package com.shop.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Collection;

/**
 * Created by LalinPethiyagoda on 21/07/2015.
 */
@Entity
@Table(name = "product", schema = "public", catalog = "Shop")
public class ProductEntity {
    private Integer productid;
    private String itemcode;
    private String itemdescription;
    private BigInteger unitprice;
    private Integer quantityinstock;
    private Collection<OrderitemEntity> orderitemsByProductid;
    private CategoryEntity categoryByCategoryid;
    private ProductEntity productByProductid;
    private ProductEntity productByProductid_0;
    private Collection<ProductimageEntity> productimagesByProductid;
    private Collection<StockEntity> stocksByProductid;

    @Id
    @Column(name = "productid")
    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
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

    @Basic
    @Column(name = "unitprice")
    public BigInteger getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(BigInteger unitprice) {
        this.unitprice = unitprice;
    }

    @Basic
    @Column(name = "quantityinstock")
    public Integer getQuantityinstock() {
        return quantityinstock;
    }

    public void setQuantityinstock(Integer quantityinstock) {
        this.quantityinstock = quantityinstock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductEntity that = (ProductEntity) o;

        if (productid != null ? !productid.equals(that.productid) : that.productid != null) return false;
        if (itemcode != null ? !itemcode.equals(that.itemcode) : that.itemcode != null) return false;
        if (itemdescription != null ? !itemdescription.equals(that.itemdescription) : that.itemdescription != null)
            return false;
        if (unitprice != null ? !unitprice.equals(that.unitprice) : that.unitprice != null) return false;
        if (quantityinstock != null ? !quantityinstock.equals(that.quantityinstock) : that.quantityinstock != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productid != null ? productid.hashCode() : 0;
        result = 31 * result + (itemcode != null ? itemcode.hashCode() : 0);
        result = 31 * result + (itemdescription != null ? itemdescription.hashCode() : 0);
        result = 31 * result + (unitprice != null ? unitprice.hashCode() : 0);
        result = 31 * result + (quantityinstock != null ? quantityinstock.hashCode() : 0);
        return result;
    }

    public Collection<OrderitemEntity> getOrderitemsByProductid() {
        return orderitemsByProductid;
    }

    public void setOrderitemsByProductid(Collection<OrderitemEntity> orderitemsByProductid) {
        this.orderitemsByProductid = orderitemsByProductid;
    }

    @ManyToOne
    @JoinColumn(name = "categoryid", referencedColumnName = "categoryid")
    public CategoryEntity getCategoryByCategoryid() {
        return categoryByCategoryid;
    }

    public void setCategoryByCategoryid(CategoryEntity categoryByCategoryid) {
        this.categoryByCategoryid = categoryByCategoryid;
    }

    @OneToOne
    @JoinColumn(name = "productid", referencedColumnName = "productid", nullable = false)
    public ProductEntity getProductByProductid() {
        return productByProductid;
    }

    public void setProductByProductid(ProductEntity productByProductid) {
        this.productByProductid = productByProductid;
    }

    @OneToOne(mappedBy = "productByProductid")
    public ProductEntity getProductByProductid_0() {
        return productByProductid_0;
    }

    public void setProductByProductid_0(ProductEntity productByProductid_0) {
        this.productByProductid_0 = productByProductid_0;
    }

    public Collection<ProductimageEntity> getProductimagesByProductid() {
        return productimagesByProductid;
    }

    public void setProductimagesByProductid(Collection<ProductimageEntity> productimagesByProductid) {
        this.productimagesByProductid = productimagesByProductid;
    }

    public Collection<StockEntity> getStocksByProductid() {
        return stocksByProductid;
    }

    public void setStocksByProductid(Collection<StockEntity> stocksByProductid) {
        this.stocksByProductid = stocksByProductid;
    }
}
