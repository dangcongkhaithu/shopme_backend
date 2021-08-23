package com.khaithumc.shopme_backend.repository;

import com.khaithumc.shopme_backend.model.ChildCategory;
import com.khaithumc.shopme_backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "SELECT * FROM products WHERE name like %?1% ", nativeQuery = true)
    List<Product> search(String keyword);

    Product findByName(String productName);

    Product findProductById(int id);
}

