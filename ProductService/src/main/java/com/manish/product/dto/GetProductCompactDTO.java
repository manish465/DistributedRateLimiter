package com.manish.product.dto;

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
public class GetProductCompactDTO {
    private String id;
    private String name;
    private BigDecimal price;
    private List<String> category;
}
