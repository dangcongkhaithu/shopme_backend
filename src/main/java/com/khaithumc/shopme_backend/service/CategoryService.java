package com.khaithumc.shopme_backend.service;

import com.khaithumc.shopme_backend.model.Category;
import com.khaithumc.shopme_backend.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryService {

    private final CategoryRepository categoryrepository;

    public CategoryService(CategoryRepository categoryrepository) {
        this.categoryrepository = categoryrepository;
    }

    public List<Category> listCategories() {
        return categoryrepository.findAll();
    }

    public void createCategory(Category category) {
        categoryrepository.save(category);
    }

    public Category readCategory(String categoryName) {
        return categoryrepository.findByCategoryName(categoryName);
    }

    public Optional<Category> readCategory(Integer categoryId) {
        return categoryrepository.findById(categoryId);
    }
}
