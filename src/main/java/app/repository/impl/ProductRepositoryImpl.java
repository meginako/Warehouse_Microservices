package app.repository.impl;

import app.common.search.BaseSearchCriteria;
import app.common.search.ProductSearchCriteria;
import app.common.utils.SearchUtils;
import app.model.Product;
import app.repository.ProductRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class ProductRepositoryImpl implements ProductRepositoryCustom {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Page<Product> search(BaseSearchCriteria<ProductSearchCriteria> criteria) {
        Pageable pageable = SearchUtils.pageableOf(criteria);
        return new PageImpl<>(mongoTemplate.find(SearchUtils.searchQuery(criteria.getFilterDto()).with(pageable),
                Product.class, "product"),
                pageable, countProductsQuery(SearchUtils.searchQuery(criteria.getFilterDto())));
    }

    private long countProductsQuery(Query query) {
        return mongoTemplate.find(query, Product.class, "product")
                .size();
    }
}
