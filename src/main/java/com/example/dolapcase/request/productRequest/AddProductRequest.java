package com.example.dolapcase.request.productRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddProductRequest extends BaseProductRequest{

    private Long categoryId;
}
