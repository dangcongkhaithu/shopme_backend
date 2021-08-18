package com.khaithumc.shopme_backend.service;

import com.khaithumc.shopme_backend.dto.product.ProductDto;
import com.khaithumc.shopme_backend.exceptions.ProductNotExistException;
import com.khaithumc.shopme_backend.model.ChildCategory;
import com.khaithumc.shopme_backend.model.Product;
import com.khaithumc.shopme_backend.repository.ProductRepository;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.BooleanJunction;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product readCategory(String productName) {
        return productRepository.findByName(productName);
    }

    public Optional<Product> readCategory(Integer productId) {
        return productRepository.findById(productId);
    }


    public List<ProductDto> listProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            ProductDto productDto = getDtoFromProduct(product);
            productDtos.add(productDto);
        }
        return productDtos;
    }

    public static ProductDto getDtoFromProduct(Product product) {
        ProductDto productDto = new ProductDto(product);
        return productDto;
    }

    public static Product getProductFromDto(ProductDto productDto, ChildCategory category) {
        Product product = new Product(productDto, category);
        return product;
    }

    public void addProduct(ProductDto productDto, ChildCategory category) {
        Product product = getProductFromDto(productDto, category);
        productRepository.save(product);
    }

    public void updateProduct(Integer productID, ProductDto productDto, ChildCategory category) {
        Product product = getProductFromDto(productDto, category);
        product.setId(productID);
        productRepository.save(product);
    }


    public Product getProductById(Integer productId) throws ProductNotExistException {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (!optionalProduct.isPresent())
            throw new ProductNotExistException("Product id is invalid " + productId);
        return optionalProduct.get();
    }

    @PersistenceContext
    private EntityManager em;

    public List<Product> search(String keywords) {
        return productRepository.search(keywords);
    }

}
