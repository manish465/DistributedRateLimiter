package com.manish.search.mapper;

import com.manish.search.dto.GetProductCompactDTO;
import com.manish.search.entity.ProductSearchDocument;
import com.manish.search.event.ProductUpsertEvent;
import org.springframework.stereotype.Component;

@Component
public class ProductSearchMapper {
    public ProductSearchDocument toDocument(ProductUpsertEvent event) {
        return ProductSearchDocument.builder()
                .productId(event.getProductId())
                .name(event.getName())
                .description(event.getDescription())
                .tags(event.getTags())
                .category(event.getCategory())
                .price(event.getPrice())
                .build();
    }

    public static GetProductCompactDTO toCompact(ProductSearchDocument productSearchDocument) {
        return GetProductCompactDTO.builder()
                .id(productSearchDocument.getProductId())
                .name(productSearchDocument.getName())
                .price(productSearchDocument.getPrice())
                .category(productSearchDocument.getCategory())
                .build();
    }
}
