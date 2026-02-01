package com.manish.search.controller;

import com.manish.search.dto.GetProductCompactDTO;
import com.manish.search.service.ProductSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/search/product")
@RequiredArgsConstructor
public class ProductSearchController {

    private final ProductSearchService productSearchService;

    @GetMapping
    public ResponseEntity<Page<GetProductCompactDTO>> search(@RequestParam String q, Pageable pageable) {
        return ResponseEntity.ok(productSearchService.search(q, pageable));
    }
}
