package com.manish.product.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductUpsertEvent {
    private String productId;
    private String name;
    private String description;
    private List<String> tags;
    private List<String> category;
    private BigDecimal price;
}
