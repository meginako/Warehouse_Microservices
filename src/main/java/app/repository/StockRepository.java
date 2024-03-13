package app.repository;

import app.model.Stock;
import app.projection.StockProjection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface StockRepository extends MongoRepository<Stock, String>, StockRepositoryCustom {

  //todo define the query
  @Query("{'id': '1'}")
    List<StockProjection> findStockByProductAndDate(@Param("productCode") String productCode, @Param("date") LocalDateTime date);
}
