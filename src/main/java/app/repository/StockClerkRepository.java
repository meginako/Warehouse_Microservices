package app.repository;

import app.model.StockClerk;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockClerkRepository extends MongoRepository<StockClerk, String> {

    Optional<StockClerk> findByRegistryNumber(String registryNumber);
}
