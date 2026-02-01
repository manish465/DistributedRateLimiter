package com.manish.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@AllArgsConstructor
public class PriceHistory {
    private BigDecimal price;
    private Instant changedAt;
}
