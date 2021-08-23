package com.khaithumc.shopme_backend.controller;

import com.khaithumc.shopme_backend.common.ApiResponse;
import com.khaithumc.shopme_backend.dto.product.ProductDto;
import com.khaithumc.shopme_backend.exceptions.AuthenticationFailException;
import com.khaithumc.shopme_backend.exceptions.CartItemNotExistException;
import com.khaithumc.shopme_backend.model.ChildCategory;
import com.khaithumc.shopme_backend.model.Product;
import com.khaithumc.shopme_backend.service.ChildCategoryService;
import com.khaithumc.shopme_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    ChildCategoryService categoryService;

    @GetMapping("/list")
    public ResponseEntity<List<ProductDto>> listProducts() {
        List<ProductDto> body = productService.listProducts();
        return new ResponseEntity<List<ProductDto>>(body, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> body = productService.getAllProducts();
        return new ResponseEntity<List<Product>>(body, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addProduct(@RequestBody ProductDto productDto) {
        Optional<ChildCategory> optionalCategory = categoryService.readCategory(productDto.getCategoryId());
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category is invalid"), HttpStatus.CONFLICT);
        }
        ChildCategory category = optionalCategory.get();
        productService.addProduct(productDto, category);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been added"), HttpStatus.CREATED);
    }

    @PostMapping("/update/{productID}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("productID") Integer productID, @RequestBody @Valid ProductDto productDto) {
        Optional<ChildCategory> optionalCategory = categoryService.readCategory(productDto.getCategoryId());
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category is invalid"), HttpStatus.CONFLICT);
        }
        ChildCategory category = optionalCategory.get();
        productService.updateProduct(productID, productDto, category);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been updated"), HttpStatus.OK);
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<Product>> search(@PathVariable String keyword) {
        List<Product> products = productService.search(keyword);

        return  new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable("productId") int productId) throws AuthenticationFailException, CartItemNotExistException {
        productService.deleteProduct(productId);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);
    }
}
