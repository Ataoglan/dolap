package com.example.dolapcase.service.impl;

import com.example.dolapcase.exception.exceptions.productExceptions.ProductAlreadyExistsException;
import com.example.dolapcase.exception.exceptions.productExceptions.ProductNotFoundException;
import com.example.dolapcase.model.Product;
import com.example.dolapcase.repository.CategoryRepository;
import com.example.dolapcase.repository.ProductRepository;
import com.example.dolapcase.request.productRequest.AddProductRequest;
import com.example.dolapcase.request.productRequest.UpdateProductRequest;
import com.example.dolapcase.response.ApiResponse;
import com.example.dolapcase.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public ResponseEntity<?> save(AddProductRequest addProductRequest) {
        if (productRepository.existsByName(addProductRequest.getName())){
            return new ResponseEntity(new ApiResponse(false, "product is already added"), HttpStatus.BAD_REQUEST);
        }


        Product product = new Product();

        product.setName(addProductRequest.getName());
        product.setExplanation(addProductRequest.getExplanation());
        product.setPrice(addProductRequest.getPrice());
        product.setCategory(categoryRepository.findById(addProductRequest.getCategoryId()).get());

        productRepository.save(product);

        return new ResponseEntity<>(new ApiResponse(true, "product is added"), HttpStatus.ACCEPTED);
    }

    @Override
    @Transactional
    public ResponseEntity<?> update(UpdateProductRequest updateProductRequest) {
        Product product = new Product();

        product = productRepository.findByName(updateProductRequest.getName()).orElseThrow(()-> new ProductNotFoundException());

        product.setName(updateProductRequest.getName());
        product.setExplanation(updateProductRequest.getExplanation());
        product.setPrice(updateProductRequest.getPrice());
        product.setCategory(updateProductRequest.getCategory());

        productRepository.save(product);

        return new ResponseEntity(new ApiResponse(true, "product is updated"), HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        productRepository.findById(id).orElseThrow(()-> new ProductAlreadyExistsException());
        productRepository.deleteById(id);

        return new ResponseEntity<>(new ApiResponse(true, "Product is deleted"), HttpStatus.ACCEPTED);
    }

    @Override
    public Page getList(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo,pageSize, Sort.by(sortBy));
        Page<Product> page = productRepository.findAll(pageable);
        return page;
    }

    public List<Product> getProducts(){
        List<Product> products;

        products = productRepository.findAll();

        Collections.sort(products, Comparator.comparing(product -> product.getCategory().getName()));

        return products;
    }
}
