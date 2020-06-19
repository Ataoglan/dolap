package com.example.dolapcase.controller;

import com.example.dolapcase.model.Category;
import com.example.dolapcase.repository.CategoryRepository;
import com.example.dolapcase.request.productRequest.AddProductRequest;
import com.example.dolapcase.service.impl.CategoryServiceImpl;
import com.example.dolapcase.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

public class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductServiceImpl productService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void it_should_add_product(){
        AddProductRequest addProductRequest = null;
        Category category = categoryRepository.findByName("Bilgisayar").get();

        addProductRequest.setName("laptop");
        addProductRequest.setExplanation("4 gb ram, 500gb ssd");
        addProductRequest.setPrice(4500);
        addProductRequest.setCategory(category);

        productController.addProduct(addProductRequest);

        var productRequestArgumentCaptor = ArgumentCaptor.forClass(AddProductRequest.class);
        verify(productService).save(productRequestArgumentCaptor.capture());
        var capturedProductRequest = productRequestArgumentCaptor.getValue();
        assertThat(capturedProductRequest).isEqualToComparingFieldByField(addProductRequest);
    }
}
