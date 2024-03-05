package app.repository;

import app.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>, ProductRepositoryCustom {

    Optional<Product> findByCode(String code);
}
