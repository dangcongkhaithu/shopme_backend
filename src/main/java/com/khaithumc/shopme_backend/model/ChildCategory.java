package com.khaithumc.shopme_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.khaithumc.shopme_backend.dto.category.ChildCategoryDto;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "child_categories")
public class ChildCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "category_name")
    private @NotBlank String categoryName;

    private @NotBlank String description;

    private @NotBlank String imageUrl;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    Set<Product> products;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "parent_id", nullable = false)
    Category category;

    public ChildCategory(ChildCategoryDto childCategoryDto, Category category) {
        this.categoryName = childCategoryDto.getCategoryName();
        this.description = childCategoryDto.getDescription();
        this.imageUrl = childCategoryDto.getImageUrl();
        this.category = category;
    }

    public ChildCategory(String categoryName, String description, String imageUrl, Category category) {
        this.categoryName = categoryName;
        this.description = description;
        this.imageUrl = imageUrl;
        this.category = category;
    }

    public ChildCategory() {
    }

    public Integer getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
