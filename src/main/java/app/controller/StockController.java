package app.controller;

import app.common.search.BaseSearchCriteria;
import app.dto.StockDto;
import app.model.Stock;
import app.projection.StockProjection;
import app.common.search.StockSearchCriteria;
import app.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("stock")
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("snapshot")
    public List<StockProjection> findStockByProductAndDateTime(
            @RequestParam String productCode,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date) {
        return this.stockService.findStockByProductAndDate(productCode, date);
    }

    @GetMapping
    public List<StockDto> findAll() {
        return this.stockService.findAll();
    }

    @PostMapping("search")
    public Page<Stock> search(@RequestBody BaseSearchCriteria<StockSearchCriteria> searchRequest) {
        return this.stockService.search(searchRequest);
    }
}
