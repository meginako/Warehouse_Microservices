package app.service;

import app.common.search.BaseSearchCriteria;
import app.dto.ProductDto;
import app.model.Product;
import app.common.search.ProductSearchCriteria;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    ProductDto findById(String id);

    List<ProductDto> findAll();

    ProductDto save(ProductDto productDto);

    void deleteById(String id);

    Page<Product> search(BaseSearchCriteria<ProductSearchCriteria> criteria);
}
