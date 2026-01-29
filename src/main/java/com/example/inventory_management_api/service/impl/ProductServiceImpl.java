package com.example.inventory_management_api.service.impl;

import com.example.inventory_management_api.dto.ProductRequest;
import com.example.inventory_management_api.dto.ProductResponse;
import com.example.inventory_management_api.entity.Product;
import com.example.inventory_management_api.exception.BadRequestException;
import com.example.inventory_management_api.repository.ProductRepository;
import com.example.inventory_management_api.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;




@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductResponse toResponse(Product product){
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setStock(product.getStock());
        productResponse.setPrice(product.getPrice());

        return productResponse;

    }

    @Override
    public ProductResponse create(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setStock(productRequest.getStock());
        product.setPrice(productRequest.getPrice());
        productRepository.save(product);

        return toResponse(productRepository.save(product));
    }



    @Override
    public Page<ProductResponse> getAll(Pageable pageable) {
        return productRepository.findAll(pageable).map(this::toResponse);
//        MASIH ERROR
    }

    @Override
    public ProductResponse getById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Product Not Found"));
        return toResponse(product);
    }

    @Override
    public ProductResponse update(Long id, ProductRequest productRequest) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Product not found"));

        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setStock(productRequest.getStock());

        return toResponse(productRepository.save(product));
    }

    @Override
    public void delete(Long id) {

        if(!productRepository.existsById(id)){
            throw new BadRequestException("Product not found");
        }

        productRepository.deleteById(id);

    }
}
