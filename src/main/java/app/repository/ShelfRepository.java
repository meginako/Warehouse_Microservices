package app.repository;

import app.model.Shelf;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShelfRepository extends MongoRepository<Shelf, String> {

    Optional<Shelf> findByCode(String code);
}
