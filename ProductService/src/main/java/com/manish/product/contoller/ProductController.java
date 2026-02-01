package com.manish.product.contoller;

import com.manish.product.dto.*;
import com.manish.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody AddProductDTO addProductDTO) {
        return new ResponseEntity<>(productService.addProduct(addProductDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetProductDetailsDTO> getProductDetails(@PathVariable String id) {
        return new ResponseEntity<>(productService.getProductDetails(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Page<GetProductCompactDTO>> getProductList(Pageable pageable) {
        return new ResponseEntity<>(productService.getProductList(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}/price/history")
    public ResponseEntity<GetProductPriceHistoryDTO> getProductPriceHistory(@PathVariable String id) {
        return new ResponseEntity<>(productService.getProductPriceHistory(id), HttpStatus.OK);
    }

    @PutMapping("/change/price")
    public ResponseEntity<String> updateProductPrice(@RequestBody UpdatePriceDTO updatePriceDTO) {
        return new ResponseEntity<>(productService.updateProductPrice(updatePriceDTO), HttpStatus.OK);
    }

    @PutMapping("/change/details")
    public ResponseEntity<String> updateProduct(@RequestBody UpdateProductDTO updateProductDTO) {
        return new ResponseEntity<>(productService.updateProduct(updateProductDTO), HttpStatus.OK);
    }
}
