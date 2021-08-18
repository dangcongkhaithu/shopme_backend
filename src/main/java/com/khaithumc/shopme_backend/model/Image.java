package com.khaithumc.shopme_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.khaithumc.shopme_backend.dto.image.ImageDto;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "imageurl")
    private String imageUrl;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id")
    private Product product;

    public Image() {

    }

    public Image(String imageUrl, Product product) {
        this.imageUrl = imageUrl;
        this.product = product;
    }

    public Image(ImageDto imageDto, Product product) {
        this.id = imageDto.getId();
        this.imageUrl = imageDto.getImageUrl();
        this.product = product;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
