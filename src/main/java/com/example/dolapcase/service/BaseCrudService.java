package com.example.dolapcase.service;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;


public interface BaseCrudService<T, K>{
    public ResponseEntity<?> save(T t);
    public ResponseEntity<?> update(K k);
    public ResponseEntity<?> delete(Long id);
    public Page getList(final Integer pageNo, final Integer pageSize, final String sortBy);
}
