package app.repository.impl;

import app.common.search.PageSearchResult;
import app.model.Product;
//import app.model.QProduct;
import app.repository.ProductRepositoryCustom;
import app.search.ProductSearchCriteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductRepositoryImpl implements ProductRepositoryCustom {
    @Autowired
    MongoTemplate mongoTemplate;
    //TODO CREATE QUERY LOGIC
    @Override
    public PageSearchResult<Product> search(ProductSearchCriteria criteria) {
        return null;
    }
/*
    private static final QProduct qProduct = QProduct.product;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public PageSearchResult<Product> search(ProductSearchCriteria criteria) {
        JPAQuery<Product> query = new JPAQuery<Product>(entityManager)
                .from(qProduct)
                .where(predicateOf(criteria))
                .orderBy(SearchUtils.orderSpecifierOf(criteria, orderMap(), ProductSearchCriteria.DEFAULT_ORDER_BY));

        return super.executeQuery(criteria, query);
    }

    private Predicate predicateOf(ProductSearchCriteria criteria) {
        BooleanBuilder predicate = new BooleanBuilder();

        Long id = criteria.getId();
        if(id != null)
            predicate.and(qProduct.id.eq(criteria.getId()));

        String code = criteria.getCode();
        if(StringUtils.isNotBlank(code))
            predicate.and(qProduct.code.containsIgnoreCase(code));

        MeasurementUnit measurementUnit = criteria.getMeasurementUnit();
        if(measurementUnit != null)
            predicate.and(qProduct.measurementUnit.eq(measurementUnit));

        String description = criteria.getDescription();
        if(StringUtils.isNotBlank(description))
            predicate.and(qProduct.description.containsIgnoreCase(description));

        return predicate;
    }

    private HashMap<String, Path> orderMap() {
        HashMap<String, Path> map = new HashMap<>();

        map.put(ProductSearchCriteria.ORDER_BY_ID, qProduct.id);
        map.put(ProductSearchCriteria.ORDER_BY_CODE, qProduct.code);
        map.put(ProductSearchCriteria.ORDER_BY_MEASUREMENT_UNIT, qProduct.measurementUnit);

        return map;
    }*/
}
