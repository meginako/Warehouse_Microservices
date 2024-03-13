package app.common.search;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StockSearchCriteria {

    // warehouse
    private Long warehouseId;
    private String warehouseDescription;

    // shelf
    private Long shelfId;
    private String shelfCode;

    // product
    private Long productId;
    private String productCode;
}
