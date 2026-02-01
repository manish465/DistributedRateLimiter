package com.manish.product.service;

import com.manish.product.dto.*;
import com.manish.product.entity.PriceHistory;
import com.manish.product.entity.Pricing;
import com.manish.product.entity.Product;
import com.manish.product.exception.ApplicationException;
import com.manish.product.mapper.ProductMapper;
import com.manish.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public String addProduct(AddProductDTO addProductDTO) {
        Product product;

        try {
            product = productRepository.save(productMapper.toProduct(addProductDTO));
        } catch (Exception e) {
            throw new ApplicationException("Could not add new product");
        }

        kafkaTemplate.send("product-events", productMapper.toProductUpsertEvent(product));
        return "Create product with product id : " + product.getId();
    }

    public GetProductDetailsDTO getProductDetails(String id) {
        Optional<Product> productOptional = productRepository.findById(id);

        if(productOptional.isEmpty()) throw new ApplicationException("Product dose not exist");
        return productMapper.toProductDetails(productOptional.get());
    }

    public Page<GetProductCompactDTO> getProductList(Pageable pageable) {
        return productRepository.findAll(pageable).map(productMapper::toProductCompact);
    }

    public GetProductPriceHistoryDTO getProductPriceHistory(String id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isEmpty()) throw new ApplicationException("Product dose not exist");
        return productMapper.toProductPriceHistory(productOptional.get());
    }

    public String updateProductPrice(UpdatePriceDTO updatePriceDTO) {
        Optional<Product> productOptional = productRepository.findById(updatePriceDTO.getId());
        if(productOptional.isEmpty()) throw new ApplicationException("Product dose not exist");

        Product product = productOptional.get();
        Pricing pricing = product.getPricing();

        BigDecimal price = updatePriceDTO.getPrice();
        BigDecimal lastPrice = pricing.getPrice();
        Instant changedAt = Instant.now();
        Instant lastChangedAt = pricing.getChangedAt();

        PriceHistory priceHistory = new PriceHistory(lastPrice, lastChangedAt);

        pricing.setPrice(price);
        pricing.setChangedAt(changedAt);
        pricing.getHistory().add(priceHistory);

        productRepository.save(product);

        return "Updated the price of the product";
    }

    public String updateProduct(UpdateProductDTO updateProductDTO) {
        Optional<Product> productOptional = productRepository.findById(updateProductDTO.getId());
        if(productOptional.isEmpty()) throw new ApplicationException("Product dose not exist");

        Product product = productOptional.get();

        product.setName(updateProductDTO.getName());
        product.setDescription(updateProductDTO.getDescription());
        product.setTags(updateProductDTO.getTags());
        product.setCategory(updateProductDTO.getCategory());

        productRepository.save(product);

        return "Updated the details of the product";
    }
}
