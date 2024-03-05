package app.common.search;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class QueryExecutor {
/*

    @PersistenceContext
    private EntityManager entityManager;
    public <T, U> PageSearchResult<T> executeQuery(BaseSearchCriteria criteria, JPAQuery<T> query) {
        // Total rows without pagination
        long totalRows = query.fetchCount();

        // Pagination preparation
        int pageIndex = criteria.getPageIndex();
        int pageSize = criteria.getPageSize();
        long offset = (long) pageIndex * pageSize;

        // Apply pagination and fetch data
        List<T> pageData = query
                .offset(offset)
                .limit(pageSize)
                .fetch();

        return new PageSearchResult<>(totalRows, pageData);
    }*/


}
