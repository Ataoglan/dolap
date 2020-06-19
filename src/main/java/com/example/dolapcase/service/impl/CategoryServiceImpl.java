package com.example.dolapcase.service.impl;

import com.example.dolapcase.exception.exceptions.categoryExceptions.CategoryAlreadyExistsException;
import com.example.dolapcase.exception.exceptions.categoryExceptions.CategoryNotFoundException;
import com.example.dolapcase.model.Category;
import com.example.dolapcase.repository.CategoryRepository;
import com.example.dolapcase.request.categoryRequest.AddCategoryRequest;
import com.example.dolapcase.request.categoryRequest.UpdateCategoryRequest;
import com.example.dolapcase.response.ApiResponse;
import com.example.dolapcase.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public ResponseEntity<?> save(AddCategoryRequest addCategoryRequest) {
        if (categoryRepository.existsByName(addCategoryRequest.getName())){
            return new ResponseEntity(new ApiResponse(false, "Category is already exists"),
                    HttpStatus.BAD_REQUEST);
        }

        Category category = new Category();
        category.setName(addCategoryRequest.getName());

        categoryRepository.save(category);
        return null;
    }

    @Override
    @Transactional
    public ResponseEntity<?> update(UpdateCategoryRequest updateCategoryRequest) {
        Category category = new Category();

        categoryRepository.findByName(updateCategoryRequest.getName()).orElseThrow(()-> new CategoryAlreadyExistsException());

        category.setName(updateCategoryRequest.getName());
        categoryRepository.save(category);

        return new ResponseEntity(new ApiResponse(true, "Category is updated"), HttpStatus.ACCEPTED);
    }

    @Override
    @Transactional
    public ResponseEntity<?> delete(Long id) {
        categoryRepository.findById(id).orElseThrow(()-> new CategoryNotFoundException());
        categoryRepository.deleteById(id);

        return new ResponseEntity(new ApiResponse(true, "Category is deleted"), HttpStatus.ACCEPTED);
    }

    @Override
    public Page getList(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo,pageSize, Sort.by(sortBy));
        Page<Category> page = categoryRepository.findAll(pageable);
        return page;
    }

    public List<Category> getCategories(){
        List<Category> categories;
        categories = categoryRepository.findAll();

        return categories;
    }
}
