package app.common.utils;

import app.common.search.BaseSearchCriteria;
import app.common.search.ProductSearchCriteria;
import app.common.search.StockSearchCriteria;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class SearchUtils {

    public static <T> Pageable pageableOf(BaseSearchCriteria<T> searchRequest) {
        int pageIndex = searchRequest.getPageIndex();
        int rowsSize = searchRequest.getPageSize();
        String orderBy = searchRequest.getOrderColumn();
        Sort.Direction orderDirection = (searchRequest.getOrderAsc() != null) && (searchRequest.getOrderAsc().equals(Boolean.TRUE))
                ? Sort.Direction.ASC
                : Sort.Direction.DESC;

        return PageRequest.of(pageIndex, rowsSize, orderDirection, orderBy);
    }
    public static Query searchQuery(ProductSearchCriteria criteria){
        Query query = new Query();
        if (criteria.getId() != null) {
            query.addCriteria(Criteria.where("id").is(criteria.getId()));
        }

        if (criteria.getCode() != null) {
            query.addCriteria(Criteria.where("code").is(criteria.getCode()));
        }

        if (criteria.getDescription()!= null) {
            query.addCriteria(Criteria.where("description").is(criteria.getDescription()));
        }

        if (criteria.getMeasurementUnit() != null) {
            query.addCriteria(Criteria.where("measurementUnit").is(criteria.getMeasurementUnit().name()));
        }

        return query;
    }
    public static Query searchQuery(StockSearchCriteria criteria) {
        Query query = new Query();
        if (criteria.getWarehouseId() != null) {
            query.addCriteria(Criteria.where("warehouseId").is(criteria.getWarehouseId()));
        }
        if (criteria.getWarehouseDescription() != null) {
            query.addCriteria(Criteria.where("warehouseDescription").is(criteria.getWarehouseDescription()));
        }
        if (criteria.getShelfId() != null) {
            query.addCriteria(Criteria.where("shelfId").is(criteria.getShelfId()));
        }
        if (criteria.getShelfCode() != null) {
            query.addCriteria(Criteria.where("shelfCode").is(criteria.getShelfCode()));
        }
        if (criteria.getProductId() != null) {
            query.addCriteria(Criteria.where("productId").is(criteria.getProductId()));
        }
        if (criteria.getProductCode() != null) {
            query.addCriteria(Criteria.where("productCode").is(criteria.getProductCode()));
        }


        return query;
    }
}
