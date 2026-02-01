package com.manish.product.mapper;

import com.manish.product.dto.AddProductDTO;
import com.manish.product.dto.GetProductCompactDTO;
import com.manish.product.dto.GetProductDetailsDTO;
import com.manish.product.dto.GetProductPriceHistoryDTO;
import com.manish.product.entity.PriceHistory;
import com.manish.product.entity.Pricing;
import com.manish.product.entity.Product;
import org.springframework.data.domain.Page;
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

    public GetProductDetailsDTO toProductDetails(Product product) {
        return GetProductDetailsDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPricing().getPrice())
                .tags(product.getTags())
                .category(product.getCategory())
                .version(product.getVersion())
                .createBy(product.getCreateBy())
                .createAt(product.getCreateAt())
                .updatedBy(product.getUpdatedBy())
                .updatedAt(product.getUpdatedAt())
                .build();
    }

    public GetProductCompactDTO toProductCompact(Product product) {
        return GetProductCompactDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPricing().getPrice())
                .category(product.getCategory())
                .build();
    }

    public GetProductPriceHistoryDTO toProductPriceHistory(Product product) {
        return new GetProductPriceHistoryDTO(product.getId(), product.getPricing());
    }
}
