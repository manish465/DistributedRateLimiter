package com.manish.product.service;

import com.manish.product.dto.AddProductDTO;
import com.manish.product.entity.Product;
import com.manish.product.exception.ApplicationException;
import com.manish.product.mapper.ProductMapper;
import com.manish.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public String addProduct(AddProductDTO addProductDTO) {
        Product product;

        try {
            product = productRepository.save(productMapper.toProduct(addProductDTO));
        } catch (Exception e) {
            throw new ApplicationException("Could not add new product");
        }

        return "Create product with product id : " + product.getId();
    }
}
