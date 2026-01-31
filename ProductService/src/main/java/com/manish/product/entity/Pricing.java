package com.manish.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class Pricing {
    private BigDecimal price;
    private BigDecimal discountedPrice;
    private String currency;
    private List<PriceHistory> history;
}
