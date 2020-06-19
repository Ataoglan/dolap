package com.example.dolapcase.controller;

import com.example.dolapcase.model.Category;
import com.example.dolapcase.request.categoryRequest.AddCategoryRequest;
import com.example.dolapcase.request.categoryRequest.UpdateCategoryRequest;
import com.example.dolapcase.response.ApiResponse;
import com.example.dolapcase.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private CategoryServiceImpl categoryService;

    @Autowired
    public CategoryController (CategoryServiceImpl categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public ResponseEntity<?> getCategories() {

        List<Category> categoryList = categoryService.getCategories();

        return new ResponseEntity<>(new ApiResponse(true, categoryList.toString()), HttpStatus.ACCEPTED);
    }

    @PostMapping("/addcategory")
    public ResponseEntity<?> addCategory(@RequestBody @Valid AddCategoryRequest addCategoryRequest){
        categoryService.save(addCategoryRequest);
        return new ResponseEntity<>(new ApiResponse(true, "category is added"), HttpStatus.CREATED);
    }

    @DeleteMapping("/deletecategory/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){
        categoryService.delete(id);
        return new ResponseEntity<>(new ApiResponse(true, "category is deleted"), HttpStatus.OK);
    }

    @PutMapping("/updatecategory")
    public ResponseEntity<?> updateCategory(@RequestBody @Valid UpdateCategoryRequest updateCategoryRequest){
        categoryService.update(updateCategoryRequest);
        return new ResponseEntity<>(new ApiResponse(true, "category is updated"), HttpStatus.OK);
    }
}
