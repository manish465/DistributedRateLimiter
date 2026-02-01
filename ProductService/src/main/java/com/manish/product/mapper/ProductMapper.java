package com.manish.product.mapper;

import com.manish.product.dto.AddProductDTO;
import com.manish.product.entity.PriceHistory;
import com.manish.product.entity.Pricing;
import com.manish.product.entity.Product;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
public class ProductMapper {
    public Product toProduct(AddProductDTO addProductDTO) {
        Product product = new Product();

        PriceHistory priceHistory = new PriceHistory(addProductDTO.getPrice(), Instant.now());
        Pricing pricing = new Pricing(addProductDTO.getPrice(), List.of(priceHistory));

        product.setName(addProductDTO.getName());
        product.setDescription(addProductDTO.getDescription());
        product.setPricing(pricing);
        product.setTags(addProductDTO.getTags());
        product.setCategory(addProductDTO.getCategory());

        return product;
    }
}
