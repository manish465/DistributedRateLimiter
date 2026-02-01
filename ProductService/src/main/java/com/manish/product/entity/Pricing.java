package com.manish.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pricing {
    private BigDecimal price;
    private List<PriceHistory> history;
    private Instant changedAt;
}
