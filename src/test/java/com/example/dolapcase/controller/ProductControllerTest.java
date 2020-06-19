package com.example.dolapcase.controller;

import com.example.dolapcase.request.productRequest.AddProductRequest;
import com.example.dolapcase.request.productRequest.UpdateProductRequest;
import com.example.dolapcase.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductServiceImpl productService;

    @Test
    void it_should_add_product(){
        AddProductRequest addProductRequest = new AddProductRequest();
        Long catId = 1L;

        addProductRequest.setName("laptop");
        addProductRequest.setExplanation("4 gb ram, 500gb ssd");
        addProductRequest.setPrice(4500L);
        addProductRequest.setCategoryId(catId);

        productController.addProduct(addProductRequest);

        var productRequestArgumentCaptor = ArgumentCaptor.forClass(AddProductRequest.class);
        verify(productService).save(productRequestArgumentCaptor.capture());
        var capturedProductRequest = productRequestArgumentCaptor.getValue();
        assertThat(capturedProductRequest).isEqualToComparingFieldByField(addProductRequest);
    }

    @Test
    void it_should_edit_product() {

        UpdateProductRequest updateProductRequest= new UpdateProductRequest();

        productController.updateProduct(updateProductRequest);

        verify(productService).update(updateProductRequest);
    }

    @Test
    void it_should_delete_product() {

        long id = 1L;

        productController.deleteProduct(id);

        verify(productService).delete(id);
    }
}
