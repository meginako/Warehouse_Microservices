package app.repository;

import app.common.search.BaseSearchCriteria;
import app.model.Product;
import app.common.search.ProductSearchCriteria;
import org.springframework.data.domain.Page;

public interface ProductRepositoryCustom {

    Page<Product> search(BaseSearchCriteria<ProductSearchCriteria> criteria);
}
