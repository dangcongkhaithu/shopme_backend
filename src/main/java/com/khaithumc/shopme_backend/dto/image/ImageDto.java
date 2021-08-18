package com.khaithumc.shopme_backend.dto.image;

import com.khaithumc.shopme_backend.model.Image;

import javax.validation.constraints.NotNull;

public class ImageDto {

    private Integer id;
    private @NotNull String imageUrl;
    private @NotNull Integer productId;

    public ImageDto(@NotNull String imageUrl,@NotNull Integer productId) {
        this.imageUrl = imageUrl;
        this.productId = productId;
    }

    public  ImageDto(Image image) {
        this.setId(image.getId());
        this.setImageUrl(image.getImageUrl());
        this.setProductId(image.getProduct().getId());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
