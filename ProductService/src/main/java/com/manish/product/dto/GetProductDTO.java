package com.manish.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductDTO {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private List<String> tags;
    private List<String> category;
    private Long version;
    private String createBy;
    private Instant createAt;
    private String updatedBy;
    private Instant updatedAt;
}
