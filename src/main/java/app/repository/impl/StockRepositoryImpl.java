package app.repository.impl;

import app.common.search.BaseSearchCriteria;
import app.common.search.StockSearchCriteria;
import app.common.utils.SearchUtils;
import app.model.Stock;
import app.repository.StockRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class StockRepositoryImpl implements StockRepositoryCustom {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Page<Stock> search(BaseSearchCriteria<StockSearchCriteria> criteria) {
        Pageable pageable = SearchUtils.pageableOf(criteria);
        return new PageImpl<>(mongoTemplate.find(SearchUtils.searchQuery(criteria.getFilterDto()).with(pageable),
                Stock.class, "stock"),
                pageable, countStocksQuery(SearchUtils.searchQuery(criteria.getFilterDto())));
    }

    private long countStocksQuery(Query query) {
        return mongoTemplate.find(query, Stock.class, "stock").size();
    }
}
