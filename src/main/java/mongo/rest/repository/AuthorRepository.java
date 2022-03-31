package mongo.rest.repository;

import mongo.rest.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface AuthorRepository extends MongoRepository<Author, String> {

    @Query("{'name': ?0}")
    Author findByName(String name);
}
