package com.manish.search.service;

import com.manish.search.dto.GetProductCompactDTO;
import com.manish.search.entity.ProductSearchDocument;
import com.manish.search.mapper.ProductSearchMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.*;
import org.springframework.data.elasticsearch.core.query.StringQuery;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductSearchService {

    private final ElasticsearchOperations elasticsearchOperations;

    public Page<GetProductCompactDTO> search(String q, Pageable pageable) {

        String jsonQuery = """
        {
          "multi_match": {
            "query": "%s",
            "fields": ["name^3", "description", "tags"]
          }
        }
        """.formatted(q);

        StringQuery query = new StringQuery(jsonQuery);
        query.setPageable(pageable);

        SearchHits<ProductSearchDocument> hits =
                elasticsearchOperations.search(query, ProductSearchDocument.class);

        return SearchHitSupport.searchPageFor(hits, pageable)
                .map(SearchHit::getContent)
                .map(ProductSearchMapper::toCompact);
    }
}
