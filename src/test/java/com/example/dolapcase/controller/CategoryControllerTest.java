package com.example.dolapcase.controller;

import com.example.dolapcase.request.categoryRequest.AddCategoryRequest;
import com.example.dolapcase.request.categoryRequest.UpdateCategoryRequest;
import com.example.dolapcase.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CategoryControllerTest {

    @InjectMocks
    private CategoryController categoryController;

    @Mock
    private CategoryServiceImpl categoryService;

    @Test
    void it_should_add_category(){
        AddCategoryRequest categoryRequest = new AddCategoryRequest();

        categoryRequest.setName("Bilgisayar");

        categoryController.addCategory(categoryRequest);

        var categoryRequestArgumentCaptor = ArgumentCaptor.forClass(AddCategoryRequest.class);
        verify(categoryService).save(categoryRequestArgumentCaptor.capture());
        var capturedProductRequest = categoryRequestArgumentCaptor.getValue();
        assertThat(capturedProductRequest).isEqualToComparingFieldByField(categoryRequest);
    }

    @Test
    void it_should_edit_category() {

        UpdateCategoryRequest updateCategoryRequest= new UpdateCategoryRequest();

        categoryController.updateCategory(updateCategoryRequest);

        verify(categoryService).update(updateCategoryRequest);
    }

    @Test
    void it_should_delete_category() {

        long id = 1L;

        categoryController.deleteCategory(id);

        verify(categoryService).delete(id);
    }
}

