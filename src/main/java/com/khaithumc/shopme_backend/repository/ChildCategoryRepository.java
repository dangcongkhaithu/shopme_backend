package com.khaithumc.shopme_backend.repository;

import com.khaithumc.shopme_backend.model.ChildCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildCategoryRepository extends JpaRepository<ChildCategory, Integer> {

	ChildCategory findByCategoryName(String categoryName);

}
