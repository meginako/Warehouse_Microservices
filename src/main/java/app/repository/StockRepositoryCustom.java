package app.repository;

import app.common.search.BaseSearchCriteria;
import app.model.Stock;
import app.common.search.StockSearchCriteria;
import org.springframework.data.domain.Page;


public interface StockRepositoryCustom {

    Page<Stock> search(BaseSearchCriteria<StockSearchCriteria> criteria);
}