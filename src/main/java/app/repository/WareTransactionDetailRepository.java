package app.repository;

import app.enums.WareTransactionType;
import app.model.WareTransactionDetail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface WareTransactionDetailRepository extends MongoRepository<WareTransactionDetail, String> {

    List<WareTransactionDetail> findByWareTransactionId(String wareTransactionId);
/*
    @Query("SELECT SUM(detail.quantity) " +
            "FROM WareTransactionDetail detail " +
            "INNER JOIN WareTransaction tx ON detail.wareTransaction.id=tx.id " +
            "WHERE tx.wareTransactionType=:wareTransactionType " +
            "AND detail.product.id=:productId " +
            "AND detail.shelf.id=:shelfId")*/
    @Query("{'id': '1'}")
    Optional<Long> findTotalQuantityByProductAndShelfAndWareTransactionType(
            @Param("productId") String productId,
            @Param("shelfId") String shelfId,
            @Param("wareTransactionType") WareTransactionType wareTransactionType);

}
