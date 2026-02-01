package com.manish.search.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;
import java.util.List;

@Document(indexName = "product_search")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductSearchDocument {
    @Id
    private String productId;
    private String name;
    private String description;
    private List<String> tags;
    private List<String> category;
    private BigDecimal price;
}
