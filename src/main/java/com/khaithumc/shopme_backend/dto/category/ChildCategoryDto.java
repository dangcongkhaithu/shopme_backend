package com.khaithumc.shopme_backend.dto.category;

import com.khaithumc.shopme_backend.model.ChildCategory;

import javax.validation.constraints.NotNull;

public class ChildCategoryDto {
    private Integer id;
    private @NotNull String categoryName;
    private @NotNull String description;
    private @NotNull String imageUrl;
    private @NotNull Integer parentId;

    public ChildCategoryDto(@NotNull String categoryName,@NotNull String description,@NotNull String imageUrl,@NotNull Integer parentId) {
        this.categoryName = categoryName;
        this.description = description;
        this.imageUrl = imageUrl;
        this.parentId = parentId;
    }

    public  ChildCategoryDto(ChildCategory childCategory) {
        this.setId(childCategory.getId());
        this.setCategoryName(childCategory.getCategoryName());
        this.setDescription(childCategory.getDescription());
        this.setId(childCategory.getCategory().getId());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
