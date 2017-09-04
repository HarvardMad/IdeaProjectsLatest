package com.shop.entity;

import javax.persistence.*;
import java.util.Arrays;

/**
 * Created by LalinPethiyagoda on 21/07/2015.
 */
@Entity
@Table(name = "productimage", schema = "public", catalog = "Shop")
public class ProductimageEntity {
    private Integer imageid;
    private byte[] imagename;
    private ProductEntity productByProductid;

    @Id
    @Column(name = "imageid")
    public Integer getImageid() {
        return imageid;
    }

    public void setImageid(Integer imageid) {
        this.imageid = imageid;
    }

    @Basic
    @Column(name = "imagename")
    public byte[] getImagename() {
        return imagename;
    }

    public void setImagename(byte[] imagename) {
        this.imagename = imagename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductimageEntity that = (ProductimageEntity) o;

        if (imageid != null ? !imageid.equals(that.imageid) : that.imageid != null) return false;
        if (!Arrays.equals(imagename, that.imagename)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = imageid != null ? imageid.hashCode() : 0;
        result = 31 * result + (imagename != null ? Arrays.hashCode(imagename) : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "productid", referencedColumnName = "productid")
    public ProductEntity getProductByProductid() {
        return productByProductid;
    }

    public void setProductByProductid(ProductEntity productByProductid) {
        this.productByProductid = productByProductid;
    }
}
