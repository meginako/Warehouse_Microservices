package app.repository;

import app.model.WareTransaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WareTransactionRepository extends MongoRepository<WareTransaction, String> {
}
