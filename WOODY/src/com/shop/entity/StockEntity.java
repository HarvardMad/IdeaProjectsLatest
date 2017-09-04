package com.shop.entity;

import javax.persistence.*;

/**
 * Created by LalinPethiyagoda on 21/07/2015.
 */
@Entity
@Table(name = "stock", schema = "public", catalog = "Shop")
public class StockEntity {
    private Integer stockid;
    private String size;
    private Integer quantityinstock;
    private Integer reorderlevel;
    private ProductEntity productByProductid;
    private StockEntity stockByStockid;
    private StockEntity stockByStockid_0;

    @Id
    @Column(name = "stockid")
    public Integer getStockid() {
        return stockid;
    }

    public void setStockid(Integer stockid) {
        this.stockid = stockid;
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
    @Column(name = "quantityinstock")
    public Integer getQuantityinstock() {
        return quantityinstock;
    }

    public void setQuantityinstock(Integer quantityinstock) {
        this.quantityinstock = quantityinstock;
    }

    @Basic
    @Column(name = "reorderlevel")
    public Integer getReorderlevel() {
        return reorderlevel;
    }

    public void setReorderlevel(Integer reorderlevel) {
        this.reorderlevel = reorderlevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockEntity that = (StockEntity) o;

        if (stockid != null ? !stockid.equals(that.stockid) : that.stockid != null) return false;
        if (size != null ? !size.equals(that.size) : that.size != null) return false;
        if (quantityinstock != null ? !quantityinstock.equals(that.quantityinstock) : that.quantityinstock != null)
            return false;
        if (reorderlevel != null ? !reorderlevel.equals(that.reorderlevel) : that.reorderlevel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stockid != null ? stockid.hashCode() : 0;
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (quantityinstock != null ? quantityinstock.hashCode() : 0);
        result = 31 * result + (reorderlevel != null ? reorderlevel.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "productid", referencedColumnName = "productid", nullable = false)
    public ProductEntity getProductByProductid() {
        return productByProductid;
    }

    public void setProductByProductid(ProductEntity productByProductid) {
        this.productByProductid = productByProductid;
    }

    @OneToOne
    @JoinColumn(name = "stockid", referencedColumnName = "stockid", nullable = false)
    public StockEntity getStockByStockid() {
        return stockByStockid;
    }

    public void setStockByStockid(StockEntity stockByStockid) {
        this.stockByStockid = stockByStockid;
    }

    @OneToOne(mappedBy = "stockByStockid")
    public StockEntity getStockByStockid_0() {
        return stockByStockid_0;
    }

    public void setStockByStockid_0(StockEntity stockByStockid_0) {
        this.stockByStockid_0 = stockByStockid_0;
    }
}
