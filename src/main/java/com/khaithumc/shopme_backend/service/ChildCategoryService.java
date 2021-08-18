package com.khaithumc.shopme_backend.service;

import com.khaithumc.shopme_backend.dto.category.ChildCategoryDto;
import com.khaithumc.shopme_backend.model.Category;
import com.khaithumc.shopme_backend.model.ChildCategory;
import com.khaithumc.shopme_backend.repository.ChildCategoryRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ChildCategoryService {

	private final ChildCategoryRepository categoryrepository;

	public ChildCategoryService(ChildCategoryRepository categoryrepository) {
		this.categoryrepository = categoryrepository;
	}

	public List<ChildCategory> listCategories() {
		return categoryrepository.findAll();
	}

	public void createCategory(ChildCategory category) {
		categoryrepository.save(category);
	}

	public ChildCategory readCategory(String categoryName) {
		return categoryrepository.findByCategoryName(categoryName);
	}

	public Optional<ChildCategory> readCategory(Integer categoryId) {
		return categoryrepository.findById(categoryId);
	}

	public void updateCategory(Integer categoryID, ChildCategory newCategory) {
		ChildCategory category = categoryrepository.findById(categoryID).get();
		category.setCategoryName(newCategory.getCategoryName());
		category.setDescription(newCategory.getDescription());
		category.setProducts(newCategory.getProducts());
		category.setImageUrl(newCategory.getImageUrl());

		categoryrepository.save(category);
	}

	public void addCategory(ChildCategoryDto childCategoryDto, Category category) {
		ChildCategory childCategory = getChildCategoryFromDto(childCategoryDto, category);
		categoryrepository.save(childCategory);
	}

	public static ChildCategory getChildCategoryFromDto(ChildCategoryDto childCategoryDto, Category category) {
		ChildCategory childCategory = new ChildCategory(childCategoryDto, category);
		return childCategory;
	}

	public static ChildCategoryDto getDtoFromChildCategory(ChildCategory childCategory) {
		ChildCategoryDto childCategoryDto = new ChildCategoryDto(childCategory);
		return  childCategoryDto;
	}
}
