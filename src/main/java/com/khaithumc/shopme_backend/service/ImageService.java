package com.khaithumc.shopme_backend.service;

import com.khaithumc.shopme_backend.dto.image.ImageDto;
import com.khaithumc.shopme_backend.model.Image;
import com.khaithumc.shopme_backend.model.Product;
import com.khaithumc.shopme_backend.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public static Image getImageFromDto(ImageDto imageDto, Product product) {
        Image image = new Image(imageDto, product);
        return  image;
    }

    public static  ImageDto getDtoFromImage(Image image) {
        ImageDto imageDto = new ImageDto(image);
        return  imageDto;
    }

    public void addImage(ImageDto imageDto, Product product) {
        Image image = getImageFromDto(imageDto, product);
        imageRepository.save(image);
    }
}
