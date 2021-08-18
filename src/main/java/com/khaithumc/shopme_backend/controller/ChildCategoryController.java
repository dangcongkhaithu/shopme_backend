package com.khaithumc.shopme_backend.controller;

import com.khaithumc.shopme_backend.common.ApiResponse;
import com.khaithumc.shopme_backend.dto.category.ChildCategoryDto;
import com.khaithumc.shopme_backend.model.Category;
import com.khaithumc.shopme_backend.model.ChildCategory;
import com.khaithumc.shopme_backend.service.CategoryService;
import com.khaithumc.shopme_backend.service.ChildCategoryService;
import com.khaithumc.shopme_backend.utils.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/child_category")
public class ChildCategoryController {

    @Autowired
    private ChildCategoryService childCategoryService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<List<ChildCategory>> getCategories() {
        List<ChildCategory> body = childCategoryService.listCategories();
        return new ResponseEntity<List<ChildCategory>>(body, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addCategory(@Valid @RequestBody ChildCategoryDto childCategoryDto) {
        Optional<Category> optionalCategory = categoryService.readCategory(childCategoryDto.getParentId());
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category is invalid"), HttpStatus.CONFLICT);
        }
        Category category = optionalCategory.get();
        childCategoryService.addCategory(childCategoryDto, category);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been added"), HttpStatus.CREATED);
    }

    //TODO create an UPDATE method Giridhar
   /* @PostMapping("/update/{categoryID}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable("categoryID") Integer categoryID, @Valid @RequestBody ChildCategory category) {
        // Check to see if the category exists.
        if (Helper.notNull(childCategoryService.readCategory(categoryID))) {
            // If the category exists then update it.
            childCategoryService.updateCategory(categoryID, category);
            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "updated the category"), HttpStatus.OK);
        }

        // If the category doesn't exist then return a response of unsuccessful.
        return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category does not exist"), HttpStatus.NOT_FOUND);
    }*/
}
