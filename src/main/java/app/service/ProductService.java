package app.service;

import app.common.search.PageSearchResult;
import app.dto.ProductDto;
import app.search.ProductSearchCriteria;

import java.util.List;

public interface ProductService {

    ProductDto findById(String id);

    List<ProductDto> findAll();

    ProductDto save(ProductDto productDto);

    void deleteById(String id);

    PageSearchResult<ProductDto> search(ProductSearchCriteria criteria);
}
