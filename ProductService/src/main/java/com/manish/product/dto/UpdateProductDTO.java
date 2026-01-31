package com.manish.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductDTO {
    private String id;
    private String name;
    private String description;
    private List<String> tags;
    private List<String> category;
}
