package com.example.dolapcase.controller;

import com.example.dolapcase.model.Product;
import com.example.dolapcase.request.productRequest.AddProductRequest;
import com.example.dolapcase.request.productRequest.UpdateProductRequest;
import com.example.dolapcase.response.ApiResponse;
import com.example.dolapcase.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private ProductServiceImpl productService;

    @Autowired
    public ProductController (ProductServiceImpl productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<?> getProducts() {

        List<Product> productList = productService.getProducts();

        return new ResponseEntity<>(new ApiResponse(true, productList.toString()), HttpStatus.ACCEPTED);
    }

    @PostMapping("/addproduct")
    public ResponseEntity<?> addProduct(@RequestBody @Valid AddProductRequest addProductRequest){
        productService.save(addProductRequest);
        return new ResponseEntity<>(new ApiResponse(true, "product is added"), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteproduct/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        productService.delete(id);
        return new ResponseEntity<>(new ApiResponse(true, "product is deleted"), HttpStatus.OK);
    }

    @PutMapping("/updateproduct")
    public ResponseEntity<?> updateProduct(@RequestBody @Valid UpdateProductRequest updateProductRequest){
        productService.update(updateProductRequest);
        return new ResponseEntity<>(new ApiResponse(true, "product is updated"), HttpStatus.OK);
    }
}
