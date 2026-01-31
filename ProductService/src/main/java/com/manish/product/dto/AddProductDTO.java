package com.manish.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProductDTO {
    private String name;
    private String description;
    private BigDecimal price;
    private List<String> tags;
    private List<String> category;
}
