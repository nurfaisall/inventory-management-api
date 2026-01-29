package com.example.inventory_management_api.service;

import com.example.inventory_management_api.dto.ProductRequest;
import com.example.inventory_management_api.dto.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    ProductResponse create(ProductRequest productRequest);
    Page<ProductResponse> getAll(Pageable pageable);
    ProductResponse getById (Long id);
    ProductResponse update(Long id, ProductRequest productRequest);
    void delete(Long id);

}
