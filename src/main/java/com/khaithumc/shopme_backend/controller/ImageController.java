package com.khaithumc.shopme_backend.controller;

import com.khaithumc.shopme_backend.common.ApiResponse;
import com.khaithumc.shopme_backend.dto.image.ImageDto;
import com.khaithumc.shopme_backend.model.Product;
import com.khaithumc.shopme_backend.service.ImageService;
import com.khaithumc.shopme_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addProduct(@RequestBody ImageDto imageDto) {
        Optional<Product> optionalProduct = productService.readCategory(imageDto.getProductId());
        if (!optionalProduct.isPresent()) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category is invalid"), HttpStatus.CONFLICT);
        }
        Product product = optionalProduct.get();
        imageService.addImage(imageDto, product);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been added"), HttpStatus.CREATED);
    }
}
