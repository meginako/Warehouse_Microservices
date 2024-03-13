package app.service;

import app.common.search.BaseSearchCriteria;
import app.dto.StockDto;
import app.model.Stock;
import app.projection.StockProjection;
import app.common.search.StockSearchCriteria;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

public interface StockService {

    List<StockProjection> findStockByProductAndDate(String productCode, LocalDateTime date);

    List<StockDto> findAll();

    Page<Stock> search(BaseSearchCriteria<StockSearchCriteria> criteria);

}
