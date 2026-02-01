package com.manish.search.listener;

import com.manish.search.event.ProductUpsertEvent;
import com.manish.search.mapper.ProductSearchMapper;
import com.manish.search.repository.ProductSearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductEventConsumer {
    private final ProductSearchRepository productSearchRepository;
    private final ProductSearchMapper productSearchMapper;

    @KafkaListener(topics = "product-events")
    public void consumeAddProduct(ProductUpsertEvent event) {
        productSearchRepository.save(productSearchMapper.toDocument(event));
    }
}
