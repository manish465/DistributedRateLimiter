package com.manish.product.entity;

import com.manish.product.dto.GetProductCompactDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Document(collection = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    public GetProductCompactDTO toProductCompact;
    @Id
    private String id;
    private String name;
    private String description;
    private Pricing pricing;
    private List<String> tags;
    private List<String> category;
    @Version
    private Long version;
    private String createBy;
    @CreatedDate
    private Instant createAt;
    private String updatedBy;
    @LastModifiedDate
    private Instant updatedAt;
}