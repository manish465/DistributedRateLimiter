package com.manish.product.dto;

import com.manish.product.entity.Pricing;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductPriceHistoryDTO {
    private String id;
    private Pricing pricing;
}
