package com.shop.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by LalinPethiyagoda on 21/07/2015.
 */
@Entity
@Table(name = "category", schema = "public", catalog = "Shop")
public class CategoryEntity {
    private Integer categoryid;
    private String description;
    private CategoryEntity categoryByCategoryid;
    private CategoryEntity categoryByCategoryid_0;
    private Collection<ProductEntity> productsByCategoryid;

    @Id
    @Column(name = "categoryid")
    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryEntity that = (CategoryEntity) o;

        if (categoryid != null ? !categoryid.equals(that.categoryid) : that.categoryid != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoryid != null ? categoryid.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "categoryid", referencedColumnName = "categoryid", nullable = false)
    public CategoryEntity getCategoryByCategoryid() {
        return categoryByCategoryid;
    }

    public void setCategoryByCategoryid(CategoryEntity categoryByCategoryid) {
        this.categoryByCategoryid = categoryByCategoryid;
    }

    @OneToOne(mappedBy = "categoryByCategoryid")
    public CategoryEntity getCategoryByCategoryid_0() {
        return categoryByCategoryid_0;
    }

    public void setCategoryByCategoryid_0(CategoryEntity categoryByCategoryid_0) {
        this.categoryByCategoryid_0 = categoryByCategoryid_0;
    }

    public Collection<ProductEntity> getProductsByCategoryid() {
        return productsByCategoryid;
    }

    public void setProductsByCategoryid(Collection<ProductEntity> productsByCategoryid) {
        this.productsByCategoryid = productsByCategoryid;
    }
}
