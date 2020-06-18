package com.example.dolapcase.request.productRequest;

import com.example.dolapcase.model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProduct extends BaseProductRequest {
    private Category category;
}
